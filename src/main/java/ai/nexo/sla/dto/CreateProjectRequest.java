package ai.nexo.sla.dto;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateProjectRequest implements Request<ProjectResponse> {

    @NotEmpty
    private String title;


}