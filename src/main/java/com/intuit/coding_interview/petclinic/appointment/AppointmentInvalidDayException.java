package com.intuit.coding_interview.petclinic.appointment;

class AppointmentInvalidDayException extends RuntimeException {
    AppointmentInvalidDayException() {
        super("Business is open Monday thru Friday");
    }
}
