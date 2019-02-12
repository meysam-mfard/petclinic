package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.services.OwnerService;
import meysam.springframework.petclinic.services.PetService;
import meysam.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets()!=null) {
                owner.getPets().forEach( pet -> {
                    if (pet.getPetType()!=null) {
                        if (pet.getPetType().getId()==null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else
                        throw new RuntimeException("PetType is required!");

                    if (pet.getId()==null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);

        }
        else
            return null;
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner:map.values())
            if (owner.getLastName().equals(lastName))
                return owner;
        return null;
    }
}
