package com.intuit.coding_interview.petclinic.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppointmentInvalidDayAdvice {

    @ResponseBody
    @ExceptionHandler(AppointmentInvalidDayException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String appointmentInvalidDayHandler( AppointmentInvalidDayException ex){
        return ex.getMessage();
    }
}
