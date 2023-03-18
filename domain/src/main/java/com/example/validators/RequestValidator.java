package com.example.validators;

import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.Request;
import com.example.exceptions.DomainValidationException;

import java.util.HashSet;
import java.util.Set;

public abstract class RequestValidator {

    final Set<DomainValidationException.ValidationErrorDetails> validationErrors = new HashSet<>();

    public void validate(Request request) {
        validateSteps(request);
        throwIfHaveErrors(validationErrors);
    }

    abstract void validateSteps(Request request);

    protected void throwIfHaveErrors(Set<DomainValidationException.ValidationErrorDetails> validationErrors) {
        if (!validationErrors.isEmpty()) {
            throw new DomainValidationException(validationErrors);
        }
    }
}
