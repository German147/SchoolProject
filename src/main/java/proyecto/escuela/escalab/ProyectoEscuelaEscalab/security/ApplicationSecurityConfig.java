package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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
                .password(passwordEncoder.encode("password"))
                .roles("STUDENT")//ROLE_STUDENT
                .build();

        UserDetails evangeUser = User.builder()
                .username("evange")
                .password(passwordEncoder.encode("password"))
                .roles("TEACHER")//ROLE_TEACHER
                .build();

        UserDetails carlosUser = User.builder()
                .username("carlos")
                .password(passwordEncoder.encode("password"))
                .roles("APODERADO")//ROLE_APODERADO
                .build();

        UserDetails claudiaUser = User.builder()
                .username("claudia")
                .password(passwordEncoder.encode("pasword"))
                .roles("PRINCIPAL")//ROLE_STUDENT
                .build();
        UserDetails paolaUser = User.builder()
                .username("paola")
                .password(passwordEncoder.encode("pasword"))
                .roles("SECRETARY")//ROLE_STUDENT
                .build();
        UserDetails germanUser = User.builder()
                .username("german")
                .password(passwordEncoder.encode("pasword"))
                .roles("ADMIN")//ROLE_STUDENT
                .build();
        UserDetails maricelUser = User.builder()
                .username("maricel")
                .password(passwordEncoder.encode("pasword"))
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
