package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Pet;


public class PetServiceMap extends AbstractMapService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
