package ai.nexo.sla.controller;

import ai.nexo.sla.dto.contact.*;
import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    private final Mediator mediator;

    @Autowired
    public ContactController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse create(@RequestBody @Validated ContactCreateRequest request) {
        return this.mediator.dispatch(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse update(@PathVariable("id") final Long id, @RequestBody @Validated ContactUpdateRequest request) {
        request.setId(id);
        return this.mediator.dispatch(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> findAll() {
        return this.mediator.dispatch(new ContactFilterRequest());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse findById(@PathVariable("id") final Long id) {
        return mediator.dispatch(new ContactFindByIdRequest(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        this.mediator.dispatch(new ContactRemoveByIdRequest(id));
    }

}