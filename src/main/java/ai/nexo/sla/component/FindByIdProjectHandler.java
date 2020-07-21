package ai.nexo.sla.component;

import ai.nexo.sla.dto.FindByIdProjectRequest;
import ai.nexo.sla.dto.ProjectResponse;
import ai.nexo.sla.model.Project;
import ai.nexo.sla.service.ProjectService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FindByIdProjectHandler implements RequestHandler<FindByIdProjectRequest, ProjectResponse> {

    @Autowired
    protected ProjectService service;

    public ProjectResponse handle(FindByIdProjectRequest request) {
        log.info("handle");
        Project project = service.findById(request.getId());
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .build();
    }


}