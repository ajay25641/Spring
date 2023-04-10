package org.example.eazyschool.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.EasyClass;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.repository.EasyClassRepository;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EasyClassRepository easyClassRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model){
        ModelAndView modelAndView =new ModelAndView("classes.html");

        List<EasyClass> easyClassList=easyClassRepository.findAll();

        modelAndView.addObject("easyClassList",easyClassList);
        modelAndView.addObject("easyClass",new EasyClass());
        return modelAndView;

    }

    @RequestMapping(value="/addNewClass",method= RequestMethod.POST)
    public ModelAndView addNewClass(Model model, @ModelAttribute("easyClass") EasyClass easyClass){
        easyClassRepository.save(easyClass);
        ModelAndView modelAndView=new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping(value="/deleteClass")
    public ModelAndView deleteClass(@RequestParam(name="classId",required = true) int id){
       Optional<EasyClass>easyClass=easyClassRepository.findById(id);

       for(Person person:easyClass.get().getPersons()){
           person.setEasyClass(null);
           personRepository.save(person);
       }

       easyClassRepository.deleteById(id);
       return new ModelAndView("redirect:/admin/displayClasses");
    }

    @RequestMapping(value="/displayStudents",method=RequestMethod.GET)
    public ModelAndView displayStudents(Model model,@RequestParam(name="classId",required = true) int id){
        ModelAndView modelAndView=new ModelAndView("students.html");
        Optional<EasyClass>eazyClass=easyClassRepository.findById(id);
        /*log.info("id of the class is : "+id);

        eazyClass.ifPresent(easyClass ->{
            for(Person person:easyClass.getPersons()) log.info("name of the person is : "+person.getName());
        });*/
        modelAndView.addObject("eazyClass",eazyClass.get());
        modelAndView.addObject("person",new Person());



        return modelAndView;
    }
}
