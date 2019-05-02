package com.intuit.coding_interview.petclinic.pet;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pet {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private List<Date> appointments;

    private Pet(){} //JPA nonsense

    public Pet( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
