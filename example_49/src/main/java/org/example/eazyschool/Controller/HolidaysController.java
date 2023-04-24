package org.example.eazyschool.Controller;

//import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Holiday;
import org.example.eazyschool.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
public class HolidaysController {

    @Autowired
    HolidaysRepository holidaysRepository;

    @GetMapping(value="/holidays/{display}")
    public String getHolidays(@PathVariable String display,Model model){

        Iterable<Holiday>iterable =holidaysRepository.findAll();
        List<Holiday>holidays= StreamSupport.stream(iterable.spliterator(),false).collect(Collectors.toList());

        Holiday.Type[] types=Holiday.Type.values();
        //model.addAttribute("festival",festival);
        //model.addAttribute("federal",federal);
        boolean festival=false;
        boolean federal=false;
        if(display!=null){
            if(display.equals("all")){
                festival=true;
                federal=true;
            }
            else if(display.equals("festival")) festival=true;
            else if(display.equals("federal")) federal=true;
            model.addAttribute("festival", festival);
            model.addAttribute("federal", federal);
        }

        for(Holiday.Type type :types){
            model.addAttribute(type.toString(),(holidays.stream().filter(holiday-> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
