package ai.nexo.sla.dto.contact;

import ai.nexo.sla.model.ContactType;
import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ContactUpdateRequest implements Request<ContactResponse> {

    private Long id;
    @NotEmpty
    private String value;
    @NotNull
    private ContactType type;
    private Boolean preferred;

}