package com.intuit.coding_interview.petclinic.appointment;

class AppointmentNotFoundException extends RuntimeException {

    AppointmentNotFoundException(Long id) {
        super("Unable to find appointment: " + id);
    }
}
