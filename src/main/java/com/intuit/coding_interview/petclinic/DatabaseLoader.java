package com.intuit.coding_interview.petclinic;

import com.intuit.coding_interview.petclinic.pet.Pet;
import com.intuit.coding_interview.petclinic.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PetRepository petRepository;

    @Autowired
    public DatabaseLoader(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        petRepository.save( new Pet("Vin", "Kretz"));
        petRepository.save( new Pet("Mazzi", "Kretz"));
    }
}
