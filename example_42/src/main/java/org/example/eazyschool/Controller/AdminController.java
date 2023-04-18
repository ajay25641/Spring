package org.example.eazyschool.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Courses;
import org.example.eazyschool.Model.EasyClass;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.repository.CoursesRepository;
import org.example.eazyschool.repository.EasyClassRepository;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EasyClassRepository easyClassRepository;

    @Autowired
    private CoursesRepository coursesRepository;

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

       System.out.println("inside delete method"+easyClass.get());


       for(Person person:easyClass.get().getPersons()){
           person.setEasyClass(null);
           person.setConfirmEmail(person.getEmail());
           person.setConfirmPassword(person.getPassword());
           personRepository.save(person);
       }

       easyClassRepository.deleteById(id);
       return new ModelAndView("redirect:/admin/displayClasses");
    }

    @RequestMapping(value="/displayStudents",method=RequestMethod.GET)
    public ModelAndView displayStudents(Model model, @RequestParam(name="classId",required = true) int id, HttpSession session){

        ModelAndView modelAndView=new ModelAndView("students.html");
        Optional<EasyClass>eazyClass=easyClassRepository.findById(id);

        //this line will give error because toString method trapped in recursive reference
        //System.out.println(eazyClass.get().getPersons());


        session.setAttribute("easyClass",eazyClass.get());

        modelAndView.addObject("eazyClass",eazyClass.get());
        modelAndView.addObject("studentList",eazyClass.get());
        modelAndView.addObject("person",new Person());



        return modelAndView;
    }

    @Transactional
    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    public ModelAndView addNewStudent(@ModelAttribute Person person ,HttpSession session){

        EasyClass easyClass=(EasyClass) session.getAttribute("easyClass");

        Person personEntity=personRepository.getByEmail(person.getEmail());

        personEntity.setEasyClass(easyClass);
        personEntity.setConfirmPassword(personEntity.getPassword());
        personEntity.setConfirmEmail(personEntity.getEmail());




         //no need to save personEntity as it will get updated automatically when easyClass is saved because
        //cascade type in easyClass is persist
        //personRepository.save(personEntity);

        easyClass.getPersons().add(personEntity);
        easyClassRepository.save(easyClass);

        return new ModelAndView("redirect:/admin/displayStudents?classId="+easyClass.getClassId());



    }



    @RequestMapping(value="/deleteStudent",method=RequestMethod.GET)
    public ModelAndView deleteStudents(@RequestParam(name="personId") int personId,HttpSession session){

        EasyClass easyClass=(EasyClass) session.getAttribute("easyClass");

        Person person=personRepository.findById(personId).get();

        person.setEasyClass(null);
        person.setConfirmEmail(person.getEmail());
        person.setConfirmPassword(person.getPassword());



        easyClass.getPersons().remove(person);

        EasyClass easyClassSaved = easyClassRepository.save(easyClass);

        session.setAttribute("easyClass",easyClassSaved);

        return new ModelAndView("redirect:/admin/displayStudents?classId="+easyClass.getClassId());



    }

    @RequestMapping(value="/displayCourses",method=RequestMethod.GET)
    public ModelAndView displayCourses(Model model){


        List<Courses> courseList=coursesRepository.findAll();

        ModelAndView modelAndView=new ModelAndView("courses_secure.html");
        modelAndView.addObject("courseList",courseList);

        modelAndView.addObject("course",new Courses());

        return modelAndView;


    }

}
