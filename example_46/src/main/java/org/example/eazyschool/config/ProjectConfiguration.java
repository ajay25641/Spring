package org.example.eazyschool.config;


import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("ajay256410@gmail.com","54321");
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();

        return restTemplateBuilder.basicAuthentication("ajay256410@gmail.com","54321").build();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
               .filter(ExchangeFilterFunctions.basicAuthentication("ajay256410@gmail.com","54321"))
               .build();
    }

}
