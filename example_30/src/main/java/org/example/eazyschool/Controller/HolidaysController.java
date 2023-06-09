package org.example.eazyschool.Controller;

//import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {

    @GetMapping(value="/holidays/{display}")

    public String getHolidays(@PathVariable String display,Model model){
        List<Holiday> holidays= Arrays.asList(new Holiday(" Jan 1 ","New's year's Day", Holiday.Type.FESTIVAL),
                                              new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                                              new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                                              new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                                              new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                                              new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                                              new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                                              new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
        );
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
