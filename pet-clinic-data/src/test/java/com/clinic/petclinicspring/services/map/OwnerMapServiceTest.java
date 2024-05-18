package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.BaseEntity;
import com.clinic.petclinicspring.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class OwnerMapServiceTest {
    private static final Long OWNER_ID = 1L;
    private static final Long OTHER_OWNER_ID = 2L;
    private static final String OWNER_NAME = "Smith";
    private static final String OTHER_OWNER_NAME = "Dereck";

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(OWNER_NAME).build());
    }

    @Test
    void findAll() {
        var owners = ownerMapService.findAll();

        assertThat(owners.size()).isEqualTo(1);
        assertThat(owners.stream().map(BaseEntity::getId).collect(toSet())).contains(OWNER_ID);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertThat(ownerMapService.findAll().size()).isEqualTo(0);
    }

    @Test
    void delete() {
        var ownerById = ownerMapService.findById(OWNER_ID);
        if (ownerById.isEmpty()) {
            return;
        }

        ownerMapService.delete(ownerById.get());

        assertThat(ownerMapService.findAll().size()).isEqualTo(0);
    }

    @Test
    void saveWithId() {
        var owner = Owner.builder().id(OTHER_OWNER_ID).lastName(OTHER_OWNER_NAME).build();

        var savedOwner = ownerMapService.save(owner);

        assertThat(savedOwner).isNotNull();
        assertThat(savedOwner.getId()).isEqualTo(OTHER_OWNER_ID);
    }

    @Test
    void saveWithNotId() {
        var ownerNoId = Owner.builder().build();

        var savedOwner = ownerMapService.save(ownerNoId);

        assertThat(savedOwner).isNotNull();
        assertThat(savedOwner.getId()).isNotNull();
    }

    @Test
    void findById() {
        var owner = ownerMapService.findById(OWNER_ID);

        assertThat(owner.isPresent()).isTrue();
        assertThat(owner.get().getId()).isEqualTo(OWNER_ID);
    }

    @Test
    void findByLastName() {
        var owner = ownerMapService.findByLastName(OWNER_NAME);

        assertThat(owner).isNotNull();
        assertThat(owner.getId()).isEqualTo(OWNER_ID);
    }
}