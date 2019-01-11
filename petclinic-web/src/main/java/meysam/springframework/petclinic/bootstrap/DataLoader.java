package meysam.springframework.petclinic.bootstrap;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.model.Vet;
import meysam.springframework.petclinic.services.OwnerService;
import meysam.springframework.petclinic.services.VetService;
import meysam.springframework.petclinic.services.map.OwnerServiceMap;
import meysam.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Cristal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mary");
        owner2.setLastName("Thomson");

        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Susan");
        vet1.setLastName("Donald");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("West");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
