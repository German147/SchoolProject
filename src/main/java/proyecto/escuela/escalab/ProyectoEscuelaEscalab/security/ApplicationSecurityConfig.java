package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.auth.ApplicationUserService;

import java.util.concurrent.TimeUnit;

import static proyecto.escuela.escalab.ProyectoEscuelaEscalab.security.AplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     PasswordEncoder passwordEncoder1, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder1;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "js/*").permitAll()//this anotation alows everybody to get in the login page
                // .antMatchers("/api/**").hasRole(ADMIN.name())
                //here it is set the ROLE to the the endpoint, and in each Controller it is Configuresd the @PreAuthorize() anotation...
                .antMatchers(HttpMethod.GET, "/api/v1/alumnos").hasAnyRole(ADMIN.name(), PROFESOR.name(), PRECEPTOR.name())
                .antMatchers(HttpMethod.GET, "/api/v1/apoderados").hasAnyRole(ADMIN.name(), PRECEPTOR.name(), SECRETARIA.name())
                .antMatchers(HttpMethod.GET, "/api/v1/asignaturas").hasAnyRole(ADMIN.name(), PROFESOR.name(), PRECEPTOR.name())
                .antMatchers(HttpMethod.GET, "/api/v1/contenidos").hasAnyRole(ADMIN.name(), PROFESOR.name(), ALUMNO.name())
                .antMatchers(HttpMethod.GET, "/api/v1/cursos").hasAnyRole(ADMIN.name(), PROFESOR.name(), PRECEPTOR.name())
                .antMatchers(HttpMethod.GET, "/api/v1/ficha_medica").hasAnyRole(ADMIN.name(), PRECEPTOR.name(), SECRETARIA.name())
                .antMatchers(HttpMethod.GET, "/api/v1/profesores").hasAnyRole(ADMIN.name(), PRECEPTOR.name(), SECRETARIA.name(), ALUMNO.name())
                .antMatchers(HttpMethod.GET, "/api/v1/registro_academico").hasAnyRole(ADMIN.name(), PRECEPTOR.name(), APODERADO.name(), SECRETARIA.name())
                .antMatchers(HttpMethod.GET, "/api/v1/toma_asignaturas").hasAnyRole(ADMIN.name(), PROFESOR.name(), SECRETARIA.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/school", true)
                .passwordParameter("password")//this anotation has to be the same as the login form parameter
                .usernameParameter("username")//this anotation has to be the same as the login form parameter
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))//it by default for 2 weeks
                .key("strongpasswordmustbeset")
                .and()
                .logout()
                .logoutUrl("/logout")
                //we use GET to loogout when we have desable CSRF,but if not it must be a POST
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSIONID")
                .logoutSuccessUrl("/login");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

}
