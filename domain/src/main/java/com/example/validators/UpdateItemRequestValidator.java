package com.example.validators;


import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.UpdateItemRequest;

import static com.example.contract.constants.DomainConstants.*;
import static com.example.exceptions.DomainValidationException.ValidationErrorDetails.of;

import java.util.Objects;


public class UpdateItemRequestValidator extends CreateItemRequestValidator {

    @Override
    protected void validateSteps(CreateItemRequest createItemRequest) {
        super.validateSteps(createItemRequest);
        hasValidId((UpdateItemRequest) createItemRequest);
    }

    private void hasValidId(UpdateItemRequest request){
        if(Objects.isNull(request.getId()) || request.getId() <= 0)
            validationErrors.add(of(ID_FIELD_NAME, MISSING_ID_MESSAGE));
    }
}
