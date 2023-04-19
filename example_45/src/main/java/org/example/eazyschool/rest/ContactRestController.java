package org.example.eazyschool.rest;


import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/contact")
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

}
