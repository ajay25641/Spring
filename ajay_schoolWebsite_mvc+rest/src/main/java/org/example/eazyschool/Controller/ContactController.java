package org.example.eazyschool.Controller;


import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Contact;

import org.example.eazyschool.Services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {
    //private Logger log= LoggerFactory.getLogger(ContactController.class);

    private ContactService contactService;

    @Autowired
    ContactController(ContactService contactService){
        this.contactService=contactService;
    }

    @RequestMapping(value={"/contact"})
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

    /*@RequestMapping(value="/saveMsg",method=POST)
    //@PostMapping(value="/saveMsg")
        public ModelAndView saveContactDetails(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email , @RequestParam String subject, @RequestParam String message){
            log.info("Name is "+name);
            logr.info("mobile number is "+mobileNum);
            log.info("email is "+email);
            log.info("subject is "+subject);
            log.info("message is "+message);
            return new ModelAndView("redirect:/contact");
        }*/

      @RequestMapping(value="/saveMsg",method =POST)
       public String saveContactDetails(@Valid @ModelAttribute("contact") Contact contact , Errors errors ){
  
          if(errors.hasErrors()){
            log.error("contact form validation failed due to : ", errors.toString());
            return "contact.html"; // send back contact form along with error
          }
          contactService.saveContactDetails(contact);
          return "redirect:contact"; // reload contact form from start

      }
      @RequestMapping(value="/displayMessages/page/{currentPage}",method = GET)
      public ModelAndView displayMessagesWithOpenStatus(@RequestParam String sortField, @RequestParam String sortDir, @PathVariable int currentPage){

          Page<Contact> msgPage=contactService.getContactMessagesWithOpenStatus(sortField,sortDir,currentPage);

          List<Contact>contactMsgs=msgPage.getContent();

          ModelAndView modelAndView=new ModelAndView("messages.html");



          modelAndView.addObject("currentPage",currentPage);
          modelAndView.addObject("sortField",sortField);
          modelAndView.addObject("totalPages",msgPage.getTotalPages());
          modelAndView.addObject("totalMsgs",msgPage.getTotalElements());
          modelAndView.addObject("sortDir",sortDir);
          modelAndView.addObject("reverseSortDir",sortDir.equals("asc")?"desc":"asc");

          modelAndView.addObject("contactMsgs",contactMsgs);
          return modelAndView;

      }

      @RequestMapping(value="/closeMsg",method=GET)
      public String closeMessages(@RequestParam(required = true) int contactId){
          contactService.updateMsgStatus(contactId);
          return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
      }
    }


