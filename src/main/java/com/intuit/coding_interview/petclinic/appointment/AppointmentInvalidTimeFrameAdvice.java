package com.intuit.coding_interview.petclinic.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppointmentInvalidTimeFrameAdvice {

    @ResponseBody
    @ExceptionHandler(AppointmentInvalidTimeFrameException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String AppointmentInvalidTimeFreamHandler( AppointmentInvalidTimeFrameException ex){
        return ex.getMessage();
    }
}
