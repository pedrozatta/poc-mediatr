package ai.nexo.sla.repository;

import ai.nexo.sla.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

