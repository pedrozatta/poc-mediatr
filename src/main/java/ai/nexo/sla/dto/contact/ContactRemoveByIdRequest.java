package ai.nexo.sla.dto.contact;

import io.jkratz.mediator.core.Request;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ContactRemoveByIdRequest implements Request<ContactResponse> {

    @NotEmpty
    private Long id;

}