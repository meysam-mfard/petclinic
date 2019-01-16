package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Speciality;
import meysam.springframework.petclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
