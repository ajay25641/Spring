package org.example.eazyschool.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})

    public String displayLoginpage(@RequestParam(value="error",required = false) String error,
                                   @RequestParam(value="logout",required = false) String logout,
                                   @RequestParam(required = false) String register, Model model){
        String errorMessage=null;
        if(error!=null){
            errorMessage="Username or password is incorrect !!";
        }
        else if(logout!=null){
            errorMessage="User logged out successfully !!";
        } else if(register !=null && register.equalsIgnoreCase("true")){
            errorMessage="Your registration is successful. Login with registered credentials !!";
        }
        model.addAttribute("errorMessage",errorMessage);
        return "login.html";
    }

    @RequestMapping(value="/logout",method={RequestMethod.GET})
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout=true";
    }
}
