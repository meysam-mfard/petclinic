package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }
}
