package org.example.eazyschool.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value="/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session){

        Person person=personRepository.getByEmail(authentication.getName());
        session.setAttribute("loggedInPerson",person);
        model.addAttribute("username",person.getName());
        model.addAttribute("role",authentication.getAuthorities().toString());
        //throw new RuntimeException("It is a bad day");
        return "dashboard.html";
    }
}
