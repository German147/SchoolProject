package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "js/*")
                .permitAll()//this anotation alows everybody to get in the login page
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails lucasUser = User.builder()
                .username("lucas")
                .password("password")
                .roles("STUDENT")//ROLE_STUDENT
                .build();

        UserDetails evangeUser = User.builder()
                .username("evange")
                .password("password")
                .roles("TEACHER")//ROLE_TEACHER
                .build();

        UserDetails carlosUser = User.builder()
                .username("carlos")
                .password("password")
                .roles("APODERADO")//ROLE_STUDENT
                .build();
        UserDetails claudiaUser = User.builder()
                .username("claudia")
                .password("password")
                .roles("PRINCIPAL")//ROLE_STUDENT
                .build();
        UserDetails paolaUser = User.builder()
                .username("paola")
                .password("password")
                .roles("SECRETARY")//ROLE_STUDENT
                .build();
        UserDetails germanUser = User.builder()
                .username("german")
                .password("password")
                .roles("ADMIN")//ROLE_STUDENT
                .build();
        UserDetails maricelUser = User.builder()
                .username("maricel")
                .password("password")
                .roles("PRECEPTOR")//ROLE_STUDENT
                .build();
        return new InMemoryUserDetailsManager(
                lucasUser,
                evangeUser,
                carlosUser,
                claudiaUser,
                germanUser,
                maricelUser
        );
    }
}
