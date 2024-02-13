package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.Visit;
import com.clinic.petclinicspring.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit == null) {
            throw new VisitServiceException("Visit entity can not be null");
        }
        if (invalidVisit(visit)) {
            throw new VisitServiceException("Invalid visit: no pet or owner exists for given visit");
        }

        return super.save(visit);
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return super.findById(id);
    }

    private boolean invalidVisit(Visit visit) {
        var pet = visit.getPet();
        return pet == null
                || pet.getId() == null
                || pet.getOwner() == null
                || pet.getOwner().getId() == null;
    }
}
