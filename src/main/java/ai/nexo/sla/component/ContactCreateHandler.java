package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactCreateRequest;
import ai.nexo.sla.dto.contact.ContactResponse;
import ai.nexo.sla.model.Contact;
import ai.nexo.sla.service.ContactService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContactCreateHandler extends ContactAbstractHandler
        implements RequestHandler<ContactCreateRequest, ContactResponse> {

    @Autowired
    protected ContactService service;

    public ContactResponse handle(ContactCreateRequest request) {
        log.info("handle");
        Contact contact = service.create(toEntity(request));
        return toResponse(contact);
    }


}