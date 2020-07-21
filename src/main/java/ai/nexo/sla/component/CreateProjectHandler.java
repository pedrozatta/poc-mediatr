package ai.nexo.sla.component;

import ai.nexo.sla.dto.CreateProjectRequest;
import ai.nexo.sla.dto.ProjectResponse;
import ai.nexo.sla.model.Project;
import ai.nexo.sla.service.ProjectService;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateProjectHandler implements RequestHandler<CreateProjectRequest, ProjectResponse> {

    @Autowired
    protected ProjectService service;

    public ProjectResponse handle(CreateProjectRequest request) {
        Project project = Project.builder().title(request.getTitle()).build();
        project = service.create(project);
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .build();
    }


}