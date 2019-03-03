package meysam.springframework.petclinic.services.springDataJpa;

import meysam.springframework.petclinic.model.Owner;
import meysam.springframework.petclinic.model.Pet;
import meysam.springframework.petclinic.repositories.OwnerRepository;
import meysam.springframework.petclinic.repositories.PetRepository;
import meysam.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Thomson";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        assertEquals(LAST_NAME, service.findByLastName(LAST_NAME).getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);


        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner emptyOwner = service.findById(1L);

        assertNull(emptyOwner);
    }

    @Test
    void findAll() {

        Set<Owner> ownersSet = new HashSet<>();
        ownersSet.add(Owner.builder().id(1L).build());
        ownersSet.add(new Owner(2L,"FN","LN","ADD","C","123",new HashSet<Pet>()));

        when(ownerRepository.findAll()).thenReturn(ownersSet);

        assertEquals(2, service.findAll().size());
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}