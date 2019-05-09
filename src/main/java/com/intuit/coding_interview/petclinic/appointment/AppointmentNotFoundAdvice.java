package com.intuit.coding_interview.petclinic.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AppointmentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AppointmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String appointmentNotFoundHandler(AppointmentNotFoundException ex) {
        return ex.getMessage();
    }
}
