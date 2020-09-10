package net.morher.div.rest.error.validation;

import java.util.Collections;
import java.util.List;

public class ValidationException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;
    private final List<Violation> violations;

    public ValidationException(List<Violation> violations) {
        this.violations = Collections.unmodifiableList(violations);
    }

    public List<Violation> getViolations() {
        return violations;
    }
}
