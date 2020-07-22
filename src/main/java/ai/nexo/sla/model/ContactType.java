package ai.nexo.sla.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactType {

    EMAIL("email"), PHONE("phone");

    public final String code;

    ContactType(String code) {
        this.code = code;
    }

    @JsonValue
    public String toString() {
        return this.code;
    }

    @JsonCreator
    public static ContactType fromString(String value) {
        if (value == null) {
            return null;
        }
        for (ContactType item : ContactType.values()) {
            if (item.code.equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

}
