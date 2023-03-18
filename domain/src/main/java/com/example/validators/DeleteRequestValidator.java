package com.example.validators;

import com.example.contract.constants.DomainConstants;
import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.DeleteRequest;
import com.example.contract.requests.Request;
import com.example.exceptions.DomainValidationException;

import java.util.Objects;

public class DeleteRequestValidator extends RequestValidator{

    @Override
    void validateSteps(Request request) {

    }

    private void validateId(Request request){
        if(Objects.nonNull(((DeleteRequest)request).getId()) && ((DeleteRequest)request).getId() > 0){

        }else
            validationErrors.add(DomainValidationException.ValidationErrorDetails.of(DomainConstants.ID_FIELD_NAME, DomainConstants.MISSING_ID_MESSAGE));


    }
}
