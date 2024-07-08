package ru.netology.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Поскольку WebSecurityConfigurerAdapter устарел после версии Spring Boot 2.7 использую следующий подход:
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("READ", "WRITE", "DELETE")
                .build();
        UserDetails user = User.builder()
                .username("user01")
                .password(passwordEncoder().encode("1234"))
                .roles("READ")
                .build();
        UserDetails writer = User.builder()
                .username("author")
                .password(passwordEncoder().encode("1234"))
                .roles("WRITE", "DELETE")
                .build();
        return new InMemoryUserDetailsManager(admin, user, writer);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/persons/by-city")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}