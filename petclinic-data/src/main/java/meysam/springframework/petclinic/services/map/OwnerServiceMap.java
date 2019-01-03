package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Owner;


public class OwnerServiceMap extends AbstractMapService<Owner, Long> {

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }
}
