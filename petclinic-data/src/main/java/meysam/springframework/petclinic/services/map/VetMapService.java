package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Speciality;
import meysam.springframework.petclinic.model.Vet;
import meysam.springframework.petclinic.services.SpecialityService;
import meysam.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialities().size() > 0){
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(vet);
    }

}
