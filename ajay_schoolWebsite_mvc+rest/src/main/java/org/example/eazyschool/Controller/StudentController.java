package org.example.eazyschool.Controller;


import jakarta.servlet.http.HttpSession;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value="/displayCourses",method= RequestMethod.GET)
    public ModelAndView displayCourses(HttpSession session){

        Person person=(Person) session.getAttribute("loggedInPerson");

        //this is done so that session should remain open during lazy fetch
        person=personRepository.findById(person.getPersonId()).get();

        ModelAndView modelAndView=new ModelAndView("courses_enrolled");
        modelAndView.addObject("person",person);


        return modelAndView;
    }
}
