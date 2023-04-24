package org.example.eazyschool.Controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Address;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.Model.Profile;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller("ProfileControllerBean")
public class ProfileController {

    @Autowired
    PersonRepository personRepository;
    @RequestMapping(value="/displayProfile",method= RequestMethod.GET)
    public ModelAndView displayProfile(HttpSession session){

        Profile profile=new Profile();
        Person person=(Person) session.getAttribute("loggedInPerson");

        profile.setName(person.getName());
        profile.setEmail(person.getEmail());
        profile.setMobileNum(person.getMobileNum());

        if(person.getAddress() !=null && person.getAddress().getAddressId()>0){
            Address address=person.getAddress();
            profile.setAddress1(address.getAddress1());
            profile.setAddress2(address.getAddress2());
            profile.setCity(address.getCity());
            profile.setState(address.getState());
            profile.setZipCode(address.getZipCode());
        }

        ModelAndView modelAndView=new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);

        return modelAndView;
    }

    @RequestMapping(value="/updateProfile",method = RequestMethod.POST)
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, HttpSession session, Errors errors){

        if(errors.hasErrors()){
            return "profile.html";
        }

        Person person = (Person) session.getAttribute("loggedInPerson");

        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNum(profile.getMobileNum());

        Address address=person.getAddress();

        if(address == null || !(address.getAddressId()>0)){
           address=new Address();
        }
        address.setCity(profile.getCity());
        address.setState(profile.getState());
        address.setZipCode(profile.getZipCode());
        address.setAddress2(profile.getAddress2());
        address.setAddress1(profile.getAddress1());

        person.setAddress(address);
        personRepository.save(person);

        session.setAttribute("loggedInPerson",person);

        return "redirect:/displayProfile";
    }
}
