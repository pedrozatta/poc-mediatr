package ai.nexo.sla.service;

import ai.nexo.sla.model.Contact;
import ai.nexo.sla.model.ContactType;
import ai.nexo.sla.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    protected ContactRepository repository;

    public Contact create(Contact contact) {
        log.info("create");
        contact.setId(null);
        if (contact.getPreferred() == null) {
            contact.setPreferred(Boolean.FALSE);
        }
        return repository.save(contact);
    }

    public Contact update(Contact contact) {
        log.info("update");
        return repository.save(contact);
    }

    public List<Contact> findAll() {
        log.info("findAll");
        return repository.findAll();
    }


    public Optional<Contact> findById(Long id) {
        log.info("findById {}", id);
        return repository.findById(id);
    }

    public void remove(Long id) {
        repository.findById(id)
                .ifPresent(project -> repository.delete(project));

    }

}