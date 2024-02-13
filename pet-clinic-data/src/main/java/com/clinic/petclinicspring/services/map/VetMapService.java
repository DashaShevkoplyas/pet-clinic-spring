package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Speciality;
import com.clinic.petclinicspring.models.Vet;
import com.clinic.petclinicspring.services.SpecialityService;
import com.clinic.petclinicspring.services.VetService;
import com.clinic.petclinicspring.services.exceptions.VetServiceException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "mapservice"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet == null) {
            throw new VetServiceException("Vet entity can not be null");
        }
        if (vet.getSpecialities() == null) {
            vet.setSpecialities(new HashSet<>());
        }

        vet.getSpecialities().forEach(this::saveSpeciality);
        return super.save(vet);
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }

    private void saveSpeciality(Speciality speciality) {
        if (speciality == null) {
            throw new VetServiceException("Vet speciality can not be null");
        }
        if (speciality.getId() == null) {
            var savedSpeciality = specialityService.save(speciality);
            savedSpeciality.setId(savedSpeciality.getId());
        }
    }
}
