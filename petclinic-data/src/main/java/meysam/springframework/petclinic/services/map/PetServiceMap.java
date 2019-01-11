package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.services.PetService;


public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
