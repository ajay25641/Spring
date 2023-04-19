package org.example.eazyschool.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
                .csrf().ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers("/public/**")
                .ignoringRequestMatchers("/displayProfile")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/displayMessages").hasRole("ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/displayProfile").permitAll()
                .requestMatchers("/updateProfile").authenticated()
                .requestMatchers("/student/**").hasRole("STUDENT")
                .requestMatchers("/closeMsg/**").hasRole("ADMIN")
                .requestMatchers("/home").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/logout").permitAll()
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
        UserDetails user1= User.withDefaultPasswordEncoder()
                .username("ajay25641@gmail.com")
                .password("12345")
                .roles("STUDENT")
                .build();
        UserDetails user2= User.withDefaultPasswordEncoder()
                .username("ak61835kmr@gmail.com")
                .password("12345")
                .roles("STUDENT")
                .build();
        UserDetails admin=User.withDefaultPasswordEncoder()
                .username("ajay256410@gmail.com")
                .password("54321")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,admin);
    }
}
