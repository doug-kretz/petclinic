package com.intuit.coding_interview.petclinic.vet;

import com.intuit.coding_interview.petclinic.appointment.Appointment;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Vet {

        @Id @GeneratedValue long id;

        private String firstName;
        private String lastName;

        @OneToMany(mappedBy = "vet")
        private List<Appointment> appointments;

        private Vet(){} //JPA

        public Vet(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.appointments = new ArrayList<>();
        }
}
