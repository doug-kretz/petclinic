package com.intuit.coding_interview.petclinic.appointment;


import com.intuit.coding_interview.petclinic.pet.Pet;
import com.intuit.coding_interview.petclinic.vet.Vet;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Appointment {
    @Id @GeneratedValue long id;
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private Appointment(){} //JPA Req

    public Appointment(LocalDateTime start, LocalDateTime end, Vet vet, Pet pet) {
        this.start = start;
        this.end = end;
        this.vet = vet;
        this.pet = pet;
    }
}
