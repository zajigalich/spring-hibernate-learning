package com.my.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // secures all REST endpoints under "/api/customers"
        // and adds following security authorizations
        //
        // EMPLOYEE role can perform following
        // 1. Get a list of all customers.  GET /api/customers
        // 2. Get a single customer.  GET /api/customers/{customerId}

        //
        // MANAGER role can perform following
        // 1. Add a new customer.  POST /api/customers
        // 2. Update an existing customer.  PUT /api/customers
        //

        //
        // ADMIN role can perform following
        // 1. Delete a customer.  DELETE /api/customers/{customerId}
        //

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/customers").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.GET, "/api/v1/customers/**").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/customers/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/customers/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/customers/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

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

}
/*

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
                        //.anyRequest().authenticated()
                        .requestMatchers(HttpMethod.GET,"/api/v1/customers/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/customers").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/customers").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/customers/**").hasRole("ADMIN")
                )
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
*/
