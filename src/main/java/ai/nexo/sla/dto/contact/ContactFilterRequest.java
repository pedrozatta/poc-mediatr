package ai.nexo.sla.dto.contact;

import io.jkratz.mediator.core.Request;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ContactFilterRequest implements Request<List<ContactResponse>> {

    @NotEmpty
    private Long id;


}