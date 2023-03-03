package com.my.config;

import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource securityDataSource;

    private UserService userService;

    @Autowired
    public SecurityConfig(DataSource securityDataSource) {
        this.securityDataSource = securityDataSource;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        return new JdbcUserDetailsManager(securityDataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/customer/**").hasRole("EMPLOYEE")
                        .requestMatchers("/customer/showForm*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/customer/delete").hasRole("ADMIN")
                        .requestMatchers("/resources/**").permitAll())
                .formLogin(configurer -> configurer
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/access-denied"))
                .build();
    }
}
