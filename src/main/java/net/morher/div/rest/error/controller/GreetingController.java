package net.morher.div.rest.error.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.morher.div.rest.error.validation.ValidationException;
import net.morher.div.rest.error.validation.Violation;

@RestController
@RequestMapping("/")
public class GreetingController {

    @GetMapping("/")
    public String sayHello(@RequestParam("name") String name) {
        validateInput(name);

        return "Hello " + name;
    }

    private void validateInput(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException(Collections.singletonList(new Violation("name.not.given", "name")));
        }
        List<Violation> violations = new ArrayList<>();

        // Name should be capitalized
        if (!name.substring(0, 1).toUpperCase().equals(name.substring(0, 1))) {
            violations.add(new Violation("name.notCapitalized", "name"));
        }

        // Name should be 3 characters or longer
        if (name.length() < 3) {
            violations.add(new Violation("name.tooShort", "name"));
        }

        // Name should not end in exclamation point
        if (name.substring(name.length() - 1).equals("!")) {
            violations.add(new Violation("name.shoulNotEndInExclamationPoint", "name"));
        }

        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }

}
