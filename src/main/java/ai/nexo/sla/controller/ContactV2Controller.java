package ai.nexo.sla.controller;

import ai.nexo.sla.model.Contact;
import ai.nexo.sla.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/v2/contacts")
public class ContactV2Controller {

    @Autowired
    public ContactService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact create(@RequestBody @Validated Contact request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact update(@PathVariable("id") final Long id, @RequestBody @Validated Contact request) {
        request.setId(id);
        return service.update(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contact findById(@PathVariable("id") final Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact Not Found!"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}