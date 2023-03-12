package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

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

    /*@Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()).build();
    }*/

    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customers/**").hasRole("ADMIN"))
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(configurer -> configurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    // Why disable CSRF?
    ///
    // Spring Security 5 has CSRF enabled by default. You would need to send over CSRF tokens.
    // However, CSRF generally does not apply for REST APIs. CSRF protection is a request that could be processed by a browser by normal users.
    // If you are only creating a REST service that is used by non-browser clients, you will likely want to disable CSRF protection.
    //
    // For more details, see this link:
    // http://www.tothenew.com/blog/fortifying-your-rest-api-using-spring-security/


    // Why disable sessions?
    //
    // For our application, we would like avoid the use of cookies for sesson tracking. This should force the REST client
    // to enter user name and password for each request. However, this is not always the case depending on the REST client / browser
    // you are using. Your mileage will vary here (for example, this doesn't work in Eclipse embedded browser).
    //
    // For more details, see this link
    // http://www.baeldung.com/spring-security-session
}