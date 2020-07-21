package ai.nexo.sla.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProjectResponse {

    private final Long id;
    private final String title;


}