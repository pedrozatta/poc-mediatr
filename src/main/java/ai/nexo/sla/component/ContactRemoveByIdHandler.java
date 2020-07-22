package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactRemoveByIdRequest;
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
public class ContactRemoveByIdHandler extends ContactAbstractHandler
        implements RequestHandler<ContactRemoveByIdRequest, ContactResponse> {

    @Autowired
    protected ContactService service;

    public ContactResponse handle(ContactRemoveByIdRequest request) {
        service.remove(request.getId());
        return null;
    }


}