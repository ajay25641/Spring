package org.example.eazyschool.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.config.EazyschoolProps;
import org.example.eazyschool.repository.CoursesRepository;
import org.example.eazyschool.repository.EasyClassRepository;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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


    @Value("${eazyschool.successMessage}")
    private String message;

    @Autowired
    private Environment environment;

    @Autowired
    private EazyschoolProps eazyschoolProps;


    @RequestMapping(value="/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session){

        Person person=personRepository.getByEmail(authentication.getName());

        if(person == null || person.getPersonId()==0){
            authentication.setAuthenticated(false);
            return "redirect:/login";

        }

        session.setAttribute("loggedInPerson",person);


        model.addAttribute("username",person.getName());



        if(person !=null && person.getEasyClass()!=null){
            model.addAttribute("enrolledClass",person.getEasyClass().getName());
        }


        model.addAttribute("role",authentication.getAuthorities().toString());

        logMessages();



        return "dashboard.html";
    }

    public void logMessages(){

        log.info("INFO messages from dashboard");
        log.warn("WARN messages from dashboard");
        log.error("ERROR messages from dashboard");
        log.debug("DEBUG messages from dashboard");
        log.trace("TRACE messages from dashboard");


        log.info("display message using @value annotation "+message);

        log.info("display message using environment :"+environment.getProperty("eazyschool.successMessage"));
        log.info("display system properties java home using environment :"+environment.getProperty("JAVA_h"));


        System.out.println("pagesize from randomName "+eazyschoolProps.getPageSize());
        System.out.println("contact from randomName "+eazyschoolProps.getContact());
        System.out.println("branches from randomName "+eazyschoolProps.getBranches());

    }

}
