package com.intuit.coding_interview.petclinic.pet;

import com.intuit.coding_interview.petclinic.appointment.Appointment;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointments;

    private Pet(){} //JPA nonsense

    public Pet( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointments = new ArrayList<>();
    }
}
