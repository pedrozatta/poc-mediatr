package ai.nexo.sla.dto.contact;

import ai.nexo.sla.model.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    private Long id;
    private String value;
    private ContactType type;
    private Boolean preferred;

}