package org.example.eazyschool.rest;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Constants.Constants;
import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.Model.Response;
import org.example.eazyschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(path="/api/contact",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(origins = "*")
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(value="/getMessagesByStatus")
    public List<Contact> getMessagesByStatus(@RequestParam(name="status") String status){

        return contactRepository.findByStatus(status);

    }


    @GetMapping(value="/getAllMessagesByStatus")
    public List<Contact> getAllMessagesByStatus(@RequestBody Contact contact){

        if(contact !=null && contact.getStatus() != null){
            return contactRepository.findByStatus(contact.getStatus());
        }
        return List.of();

    }

    @PostMapping(value="/saveMsg")
    public ResponseEntity<Response>saveMsg(@RequestHeader("invocationFrom") String invocationFrom , @Valid @RequestBody Contact contact){

        log.info(String.format("Header invocationFrom = %s",invocationFrom));

        contactRepository.save(contact);

        Response response=new Response();

        response.setStatusCode("200");
        response.setStatusMsg("Message saved successfully");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isMsgSaved","true")
                .body(response);

    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response>deleteMsg(RequestEntity<Contact>requestEntity){

        HttpHeaders headers=requestEntity.getHeaders();

        headers.forEach((key,value)->{
            log.info(String.format("Header '%s' = %s",key,value.stream().collect(Collectors.joining("|"))));
        });

        Contact contact=requestEntity.getBody();

        contactRepository.deleteById(contact.getContactId());

        Response response=new Response();
        response.setStatusMsg("Message deleted successfully");
        response.setStatusCode("200");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> updateContactMsg(@RequestBody Contact contact){

        Response response=new Response();

        Optional<Contact> contactOptional=contactRepository.findById(contact.getContactId());

        if(contactOptional.isPresent()){
            contactOptional.get().setStatus(Constants.CLOSE);
            contactRepository.save(contactOptional.get());
        }
        else{
            response.setStatusCode("400");
            response.setStatusMsg("Invalid contact id received");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatusCode("200");
        response.setStatusMsg("Message successfully closed");
        return ResponseEntity
                .status(200)
                .body(response);
    }


}
