package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails garry = User.builder()
                .username("garry")
                .password("{noop}test123")
                .roles("EMPLOYEE", "ADMIN")
                .build();

        UserDetails semen = User.builder()
                .username("semen")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails dic = User.builder()
                .username("dic")
                .password("{noop}test123")
                .roles("MANAGER", "EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(garry, semen, dic);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN"))

                .formLogin(configurer -> configurer
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll())

                .logout(LogoutConfigurer::permitAll) //configurer -> configurer.permitAll()

                .exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/access-denied"))
                .build();
    }

}
