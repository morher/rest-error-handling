package net.morher.div.rest.error.validation;

import java.util.HashMap;
import java.util.Map;

public class Violation {
    private final String field;
    private final String error;
    private final Map<String, Object> values;

    public Violation(String field, String error, Map<String, Object> values) {
        this.field = field;
        this.error = error;
        this.values = values;
    }

    public Violation(String field, String error) {
        this(field, error, new HashMap<>());
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }

    public Map<String, Object> getValues() {
        return values;
    }

}
