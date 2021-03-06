package com.intuit.coding_interview.petclinic.pet;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Pet findDistinctByFirstNameAndLastName(String firstName, String lastName);
}
