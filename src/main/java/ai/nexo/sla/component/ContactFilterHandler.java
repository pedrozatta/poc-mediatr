package ai.nexo.sla.component;

import ai.nexo.sla.dto.contact.ContactFilterRequest;
import ai.nexo.sla.dto.contact.ContactResponse;
import ai.nexo.sla.service.ContactService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ContactFilterHandler extends ContactAbstractHandler
        implements RequestHandler<ContactFilterRequest, List<ContactResponse>> {

    @Autowired
    protected ContactService service;

    public List<ContactResponse> handle(ContactFilterRequest request) {
        return service.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}