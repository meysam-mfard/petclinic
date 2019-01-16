package meysam.springframework.petclinic.bootstrap;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.model.PetType;
import meysam.springframework.petclinic.model.Vet;
import meysam.springframework.petclinic.services.OwnerService;
import meysam.springframework.petclinic.services.PetTypeService;
import meysam.springframework.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Cristal");
        owner1.setAddress("1234 Park Av.");
        owner1.setCity("Boston");
        owner1.setTelephone("123123123");

        Pet johnssPet = new Pet();
        johnssPet.setPetType(savedDogPetType);
        johnssPet.setOwner(owner1);
        johnssPet.setBirthDate(LocalDate.now());
        johnssPet.setName("Rosco");
        owner1.getPets().add(johnssPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mary");
        owner2.setLastName("Thomson");
        owner2.setAddress("4567 Brick");
        owner2.setCity("Vancouver");
        owner2.setTelephone("456456456");

        Pet marysPet = new Pet();
        marysPet.setName("TommyC");
        marysPet.setOwner(owner2);
        marysPet.setBirthDate(LocalDate.now());
        marysPet.setPetType(savedCatPetType);
        owner2.getPets().add(marysPet);

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
