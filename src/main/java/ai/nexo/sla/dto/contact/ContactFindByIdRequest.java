package ai.nexo.sla.dto.contact;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ContactFindByIdRequest implements Request<ContactResponse> {

    @NotEmpty
    private Long id;


}