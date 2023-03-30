package org.example.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll()
                .and()
                .httpBasic();





        return http.build();
    }
    //this code is not working may be because it may get depreceted
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("54321").roles("USER","ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user= User.withDefaultPasswordEncoder()
                .username("ajay")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin=User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
