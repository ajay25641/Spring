package org.example.eazyschool.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class ContactController {
    private Logger logger=LoggerFactory.getLogger(ContactController.class);
    @RequestMapping(value={"/contact"})
    public String displayContactPage(){
        return "contact.html";
    }

    @RequestMapping(value={"/saveMsg"})
        public String saveContactDetails(){
            return "";
        }
    }


