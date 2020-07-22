package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactCreateRequest;
import ai.nexo.sla.dto.contact.ContactFilterRequest;
import ai.nexo.sla.dto.contact.ContactResponse;
import ai.nexo.sla.dto.contact.ContactUpdateRequest;
import ai.nexo.sla.model.Contact;
import ai.nexo.sla.service.ContactService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class ContactAbstractHandler {

    public ContactResponse toResponse(Contact contact) {
        return ContactResponse.builder()
                .id(contact.getId())
                .type(contact.getType())
                .value(contact.getValue())
                .preferred(contact.getPreferred())
                .build();
    }

    public Contact toEntity(ContactCreateRequest contact) {
        return Contact.builder()
                .type(contact.getType())
                .value(contact.getValue())
                .preferred(contact.getPreferred())
                .build();
    }

    public Contact toEntity(ContactUpdateRequest contact) {
        return Contact.builder()
                .id(contact.getId())
                .type(contact.getType())
                .value(contact.getValue())
                .preferred(contact.getPreferred())
                .build();
    }

}