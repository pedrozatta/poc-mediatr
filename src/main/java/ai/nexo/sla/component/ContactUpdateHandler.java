package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactResponse;
import ai.nexo.sla.dto.contact.ContactUpdateRequest;
import ai.nexo.sla.model.Contact;
import ai.nexo.sla.service.ContactService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContactUpdateHandler extends ContactAbstractHandler
        implements RequestHandler<ContactUpdateRequest, ContactResponse> {

    @Autowired
    protected ContactService service;

    public ContactResponse handle(ContactUpdateRequest request) {
        log.info("handle");
        Contact contact = service.update(toEntity(request));
        return toResponse(contact);
    }


}