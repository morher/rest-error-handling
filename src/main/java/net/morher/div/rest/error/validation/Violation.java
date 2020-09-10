package net.morher.div.rest.error.validation;

import java.util.HashMap;
import java.util.Map;

public class Violation {
    private final String error;
    private final String field;
    private final Map<String, Object> values;

    public Violation(String error, String field, Map<String, Object> values) {
        this.error = error;
        this.field = field;
        this.values = values;
    }

    public Violation(String error, String field) {
        this(error, field, new HashMap<>());
    }

    public String getError() {
        return error;
    }

    public String getField() {
        return field;
    }

    public Map<String, Object> getValues() {
        return values;
    }

}
