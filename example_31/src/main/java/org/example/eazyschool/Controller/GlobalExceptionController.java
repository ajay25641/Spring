package org.example.eazyschool.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e){
        ModelAndView errorPage=new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errorMsg",e.getMessage());
        return errorPage;
    }
}
