package com.intuit.coding_interview.petclinic.appointment;


import com.intuit.coding_interview.petclinic.pet.Pet;
import com.intuit.coding_interview.petclinic.vet.Vet;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;

@Data
@Entity
public class Appointment {
    private Date start;
    private Date end;

    @OneToMany
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Appointment(Date start, Date end, Vet vet, Pet pet) {
        this.start = start;
        this.end = end;
        this.vet = vet;
        this.pet = pet;
    }
}
