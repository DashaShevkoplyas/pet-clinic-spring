package com.clinic.petclinicspring.services.springdatajpa;

import com.clinic.petclinicspring.models.Owner;
import com.clinic.petclinicspring.repositories.OwnerRepository;
import com.clinic.petclinicspring.repositories.PetRepository;
import com.clinic.petclinicspring.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {
    public static final long ID = 1L;
    public static final String LAST_NAME = "Smith";

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    private Owner expectedOwner;
    private Owner expectedOwnerTwo;

    @BeforeEach
    void setUp() {
        expectedOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
        expectedOwnerTwo = Owner.builder().id(ID + 1).lastName(LAST_NAME + 1).build();
    }

    @Test
    void findAll() {
        var expectedOwners = Set.of(expectedOwner, expectedOwnerTwo);
        when(ownerRepository.findAll()).thenReturn(expectedOwners);

        var actualOwners = ownerService.findAll();

        verify(ownerRepository).findAll();
        assertThat(actualOwners).isNotNull();
        assertThat(actualOwners.size()).isEqualTo(2);
        assertThat(actualOwners).containsExactlyInAnyOrder(expectedOwner, expectedOwnerTwo);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.of(expectedOwner));

        var actualOwner = ownerService.findById(ID);

        verify(ownerRepository).findById(ID);
        assertThat(actualOwner).isNotNull();
        assertThat(actualOwner.get().getId()).isEqualTo(ID);
    }

    @Test
    void save() {
        var ownerToSave = Owner.builder().id(ID).build();
        when(ownerRepository.save(ownerToSave)).thenReturn(expectedOwner);

        var savedOwner = ownerService.save(ownerToSave);

        verify(ownerRepository).save(ownerToSave);
        assertThat(savedOwner).isNotNull();
        assertThat(savedOwner).isEqualToComparingFieldByField(expectedOwner);
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);

        verify(ownerRepository).deleteById(ID);
    }

    @Test
    void delete() {
        ownerService.delete(expectedOwner);

        verify(ownerRepository).delete(expectedOwner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(expectedOwner);

        var actualOwner = ownerService.findByLastName(LAST_NAME);

        verify(ownerRepository).findByLastName(LAST_NAME);
        assertThat(actualOwner).isEqualToComparingFieldByField(expectedOwner);
    }
}