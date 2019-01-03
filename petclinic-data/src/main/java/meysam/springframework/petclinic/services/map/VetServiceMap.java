package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Vet;


public class VetServiceMap extends AbstractMapService<Vet, Long> {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

}
