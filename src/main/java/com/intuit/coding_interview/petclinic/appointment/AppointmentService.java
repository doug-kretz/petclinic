package com.intuit.coding_interview.petclinic.appointment;


import com.intuit.coding_interview.petclinic.BusinessHours;
import com.intuit.coding_interview.petclinic.pet.Pet;
import com.intuit.coding_interview.petclinic.pet.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private  final PetRepository petRepository;

    AppointmentService(AppointmentRepository appointmentRepository, PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.petRepository = petRepository;
    }

    @GetMapping(value = "/appointments")
    List<Appointment> all() {
        return StreamSupport.stream(appointmentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/appointments")
    Appointment add(@RequestBody Appointment newAppointment) {
        //TODO: restrict to add only if appointment is allowed
        if ( invalidTime(newAppointment)){
            throw new AppointmentInvalidTimeFrameException();
        }
        if (invalidDay(newAppointment) ) {
            throw new AppointmentInvalidDayException();
        }

        if ( duplicateAppointment( newAppointment)) {
            //TODO: Throw Exception
        }

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
    void delete(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }

    private Boolean invalidDay(Appointment appointment) {
        ArrayList<DayOfWeek> daysOff = new ArrayList<>(Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
        return daysOff.contains(appointment.getStart().getDayOfWeek()) || daysOff.contains(appointment.getEnd().getDayOfWeek());
    }

    private Boolean invalidTime(Appointment appointment) {
        return BusinessHours.START.getTime().isAfter(appointment.getStart().toLocalTime())  || BusinessHours.END.getTime().isBefore(appointment.getEnd().toLocalTime());
    }

    private Boolean duplicateAppointment(Appointment appointment) {
        //TODO
        return false;
    }
}
