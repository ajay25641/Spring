package org.example.eazyschool.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping(value="/dashboard")
    public String displayDashboard(Model model, Authentication authentication){
        model.addAttribute("username",authentication.getName());
        model.addAttribute("role",authentication.getAuthorities().toString());
        //throw new RuntimeException("It is a bad day");
        return "dashboard.html";
    }
}
