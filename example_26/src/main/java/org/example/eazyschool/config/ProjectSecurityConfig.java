package org.example.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        //permit all requests inside web Application
        http.authorizeHttpRequests().anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();

        //deny all requests inside web application
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();*/
    }
}
