package com.example.validators;


import com.example.contract.requests.Request;
import com.example.contract.requests.UpdateItemRequest;
import static com.example.contract.constants.DomainConstants.*;
import static com.example.exceptions.DomainValidationException.ValidationErrorDetails.of;
import java.util.Objects;


public class UpdateItemRequestValidator extends CreateItemRequestValidator {

    @Override
    protected void validateSteps(Request request) {
        UpdateItemRequest updateItemRequest = (UpdateItemRequest) request;
        super.validateSteps(updateItemRequest);
        validateId(updateItemRequest);
    }

    private void validateId(UpdateItemRequest request){
        if(Objects.isNull(request.getId()) || request.getId() <= 0)
            validationErrors.add(of(ID_FIELD_NAME, MISSING_ID_MESSAGE));
    }
}
