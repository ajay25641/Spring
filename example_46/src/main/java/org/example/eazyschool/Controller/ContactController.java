package org.example.eazyschool.Controller;


import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Contact;


import org.example.eazyschool.Model.Response;
import org.example.eazyschool.proxy.ContactProxy;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;



@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactProxy contactProxy;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private WebClient webClient;

    @GetMapping(value="/getMessages")
    public List<Contact>getMessages(@RequestParam(name="status") String status){
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact){

        log.info(String.valueOf(contact));

        HttpHeaders httpHeaders=new HttpHeaders();

        httpHeaders.add("invocationFrom","restTemplate");

        String uri="http://localhost:8085/api/contact/saveMsg";

        HttpEntity<Contact>httpEntity=new HttpEntity<>(contact,httpHeaders);

        ResponseEntity<Response>responseEntity=restTemplate.exchange(uri, HttpMethod.POST,httpEntity, Response.class);

        return responseEntity;

    }

    @PostMapping("/saveMessage")
    public Mono<Response> saveMessage(@RequestBody Contact contact){

        log.info(String.valueOf(contact));

        String uri="http://localhost:8085/api/contact/saveMsg";

        return webClient.post().uri(uri)
                .header("invocationFrom","webClient")
                .body(Mono.just(contact),Contact.class)
                .retrieve()
                .bodyToMono(Response.class);

    }

}


