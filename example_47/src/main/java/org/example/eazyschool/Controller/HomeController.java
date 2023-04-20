package org.example.eazyschool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value={"","/home","/"})
    public String displayHomePage(Model model){
        model.addAttribute("username","ajay kumar");
        return "Home.html";
    }

    /*@RequestMapping(value={"/courses"})
    public String courseController(){
        return "courses.html";
    }*/
}
