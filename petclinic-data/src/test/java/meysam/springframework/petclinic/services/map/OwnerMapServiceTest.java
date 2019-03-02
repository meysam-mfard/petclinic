package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;
    String lastName = "Jackson";

    @BeforeEach
    void setUp() {
         ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
         ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownersSet = ownerMapService.findAll();
        assertEquals(1,ownersSet.size());
    }

    @Test
    void findById() {
        assertEquals(ownerId, ownerMapService.findById(ownerId).getId());
    }

    @Test
    void save() {

        //no Id
        Owner owner1 = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner1);
        assertNotNull(owner1.getId());

        //Existing Id
        Long id = 2L;
        Owner owner2 = ownerMapService.save(Owner.builder().id(id).build());
        assertEquals(id, owner2.getId());

        //pets
        Set<Pet> petSet = new HashSet<>();
        String petType = "cat";
        petSet.add(Pet.builder().
                petType(PetType.builder().name(petType).build())
                .build());
        Owner owner3 = ownerMapService.save(Owner.builder().pets(petSet).build());
        assertEquals(owner3.getPets().size(), 1);
        Pet pet = (Pet) owner3.getPets().toArray()[0];
        assertEquals(pet.getPetType().getName(), petType);

        //no petType
        petSet.add(Pet.builder().build());
        assertThrows(RuntimeException.class, () -> ownerMapService.save(Owner.builder().pets(petSet).build()));

    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner1 = ownerMapService.findByLastName(lastName);
        assertNotNull(owner1);
        assertEquals(ownerId, owner1.getId());

        Owner owner2 = ownerMapService.findByLastName("someName");
        assertNull(owner2);
    }
}