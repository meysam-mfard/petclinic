package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.services.OwnerService;


public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner:map.values())
            if (owner.getLastName().equals(lastName))
                return owner;
        return null;
    }
}
