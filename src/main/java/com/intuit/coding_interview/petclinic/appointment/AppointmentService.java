package com.intuit.coding_interview.petclinic.appointment;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping(value = "/appointments")
    List<Appointment> all() {
        return StreamSupport.stream(appointmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/appointments")
    Appointment add(@RequestBody Appointment newAppointment) {
        //TODO: restrict to add only if appointment is allowed
        return this.appointmentRepository.save(newAppointment);
    }

    @GetMapping("/appointments/{id}")
    Appointment get(@PathVariable Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    @PutMapping("/appointments/{id}")
    Appointment update(@RequestBody Appointment newAppointment, @PathVariable Long id) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setPet(newAppointment.getPet());
                    appointment.setStart(newAppointment.getStart());
                    appointment.setEnd(newAppointment.getEnd());
                    appointment.setVet(newAppointment.getVet());

                    return appointmentRepository.save(appointment);
                })
                .orElseGet(() -> {
                    newAppointment.setId(id);
                    return appointmentRepository.save(newAppointment);
                });
    }

    @DeleteMapping("/appointments/{id}")
    void delete(@PathVariable Long id ) {
        appointmentRepository.deleteById(id);
    }
}
