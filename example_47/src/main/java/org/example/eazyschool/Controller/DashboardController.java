package org.example.eazyschool.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.repository.CoursesRepository;
import org.example.eazyschool.repository.EasyClassRepository;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private EasyClassRepository easyClassRepository;




    @RequestMapping(value="/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session){

        Person person=personRepository.getByEmail(authentication.getName());

        session.setAttribute("loggedInPerson",person);


        model.addAttribute("username",person.getName());

        if(person !=null && person.getEasyClass()!=null){
            model.addAttribute("enrolledClass",person.getEasyClass().getName());
        }


        model.addAttribute("role",authentication.getAuthorities().toString());



        return "dashboard.html";
    }



}
