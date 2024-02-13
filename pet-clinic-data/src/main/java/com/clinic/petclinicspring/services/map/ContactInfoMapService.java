package com.clinic.petclinicspring.services.map;

import com.clinic.petclinicspring.models.ContactInfo;
import com.clinic.petclinicspring.services.ContactInfoService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "mapservice"})
public class ContactInfoMapService extends AbstractMapService<ContactInfo, Long> implements ContactInfoService {
    @Override
    public Set<ContactInfo> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(ContactInfo contactInfo) {
        super.delete(contactInfo);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public ContactInfo save(ContactInfo contactInfo) {
        return super.save(contactInfo);
    }

    @Override
    public Optional<ContactInfo> findById(Long id) {
        return super.findById(id);
    }
}
