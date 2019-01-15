package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.PetType;
import meysam.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
