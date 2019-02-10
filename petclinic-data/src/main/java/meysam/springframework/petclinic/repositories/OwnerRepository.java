package meysam.springframework.petclinic.repositories;

import meysam.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    //Query method
    Owner findByLastName(String lastName);
}
