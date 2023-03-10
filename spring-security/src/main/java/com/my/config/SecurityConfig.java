package com.my.config;

import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource dataSource;

    private final UserService userService;

    @Lazy
    @Autowired
    public SecurityConfig(DataSource dataSource, UserService userService) {
        this.dataSource = dataSource;
        this.userService = userService;
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        return new JdbcUserDetailsManager(dataSource);
    }

    /*@Bean
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
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
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
