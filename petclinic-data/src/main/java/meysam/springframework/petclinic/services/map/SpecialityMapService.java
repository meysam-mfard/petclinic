package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Speciality;
import meysam.springframework.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
