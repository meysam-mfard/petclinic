package meysam.springframework.petclinic.services;

import meysam.springframework.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
