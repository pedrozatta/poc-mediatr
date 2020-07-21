package ai.nexo.sla.controller;

import ai.nexo.sla.dto.CreateProjectRequest;
import ai.nexo.sla.dto.FindByIdProjectRequest;
import ai.nexo.sla.dto.ProjectResponse;
import ai.nexo.sla.model.Project;
import ai.nexo.sla.service.ProjectService;
import io.jkratz.mediator.core.Mediator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/projects")
public class ProjectController {

    @Autowired
    protected ProjectService service;


    private final Mediator mediator;

    @Autowired
    public ProjectController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(@RequestBody @Validated CreateProjectRequest request) {
        return this.mediator.dispatch(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponse findById(@PathVariable("id") final Long id) {
        return mediator.dispatch(new FindByIdProjectRequest(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}