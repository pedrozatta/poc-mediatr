package ai.nexo.sla.service;

import ai.nexo.sla.model.Project;
import ai.nexo.sla.model.ProjectStatus;
import ai.nexo.sla.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    protected ProjectRepository repository;


    public Project create(Project project) {
        log.info("create");
        project.setStatus(ProjectStatus.CREATED);
        return repository.save(project);
    }

    public List<Project> findAll() {
        log.info("create");
        return repository.findAll();
    }


    public Project findById(Long id) {
        log.info("findById {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado!"));
    }

    public void remove(Long id) {
        repository.findById(id)
                .ifPresent(project -> repository.delete(project));

    }

}