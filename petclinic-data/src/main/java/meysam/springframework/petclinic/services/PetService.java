package meysam.springframework.petclinic.services;

import meysam.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet fingById(Long id);

    Set<Pet> findAll();

    Pet save(Pet pet);
}
