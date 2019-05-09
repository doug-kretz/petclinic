package com.intuit.coding_interview.petclinic.appointment;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Appointment findByEndBeforeAndStartAfterAndVet_FirstNameAndVet_LastNameAndPet_FirstNameAndPet_LastName(LocalDateTime startTime, LocalDateTime endTime, String vetFName, String vetLName, String petFName, String petLName);
}
