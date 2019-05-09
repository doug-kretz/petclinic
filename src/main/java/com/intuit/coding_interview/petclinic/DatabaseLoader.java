package com.intuit.coding_interview.petclinic;

import com.intuit.coding_interview.petclinic.appointment.Appointment;
import com.intuit.coding_interview.petclinic.appointment.AppointmentRepository;
import com.intuit.coding_interview.petclinic.pet.Pet;
import com.intuit.coding_interview.petclinic.pet.PetRepository;
import com.intuit.coding_interview.petclinic.vet.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public DatabaseLoader(PetRepository petRepository, AppointmentRepository appointmentRepository) {
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        petRepository.save( new Pet("Vin", "Kretz"));
        petRepository.save( new Pet("Mazzi", "Kretz"));

        appointmentRepository.save(new Appointment(LocalDateTime.of(2019,5,8,9,0), LocalDateTime.of(2019, 5, 8, 10, 0), new Vet("George", "Washington"), new Pet("Vins", "Kretz")));
    }
}
