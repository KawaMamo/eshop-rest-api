package com.example.validators;

import com.example.contract.requests.DeleteRequest;
import com.example.contract.requests.Request;

import java.util.Objects;

import static com.example.contract.constants.DomainConstants.*;
import static com.example.exceptions.DomainValidationException.ValidationErrorDetails.*;

public class DeleteRequestValidator extends RequestValidator{

    @Override
    void validateSteps(Request request) {
        DeleteRequest deleteRequest = (DeleteRequest) request;
        validateId(deleteRequest);
    }

    private void validateId(DeleteRequest deleteRequest){
        if (!Objects.nonNull(deleteRequest.getId()) || (deleteRequest.getId()) <= 0) {
            validationErrors.add(of(ID_FIELD_NAME, MISSING_ID_MESSAGE));
        }
    }
}
