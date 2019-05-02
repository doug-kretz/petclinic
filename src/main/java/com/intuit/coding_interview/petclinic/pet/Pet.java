package com.intuit.coding_interview.petclinic.pet;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    private Pet(){} //JPA nonsense

    public Pet( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
