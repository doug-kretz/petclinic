package com.intuit.coding_interview.petclinic.appointment;

import com.intuit.coding_interview.petclinic.BusinessHours;

class AppointmentInvalidTimeFrameException extends RuntimeException{
    AppointmentInvalidTimeFrameException() {
        super( "Business is open from " + BusinessHours.START + " to " + BusinessHours.END);
    }
}
