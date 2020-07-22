package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactFindByIdRequest;
import ai.nexo.sla.dto.contact.ContactResponse;
import ai.nexo.sla.model.Contact;
import ai.nexo.sla.service.ContactService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ContactFindByIdHandler extends ContactAbstractHandler
        implements RequestHandler<ContactFindByIdRequest, ContactResponse> {

    @Autowired
    protected ContactService service;

    public ContactResponse handle(ContactFindByIdRequest request) {
        Optional<Contact> contact = service.findById(request.getId());
        if (!contact.isPresent()) {
            log.info("not found");
            return null;
        }
        return this.toResponse(contact.get());
    }


}