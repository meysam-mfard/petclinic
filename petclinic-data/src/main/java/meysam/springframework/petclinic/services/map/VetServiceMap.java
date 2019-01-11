package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Vet;
import meysam.springframework.petclinic.services.VetService;


public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

}
