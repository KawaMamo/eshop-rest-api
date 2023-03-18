package com.example.validators;

import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.Request;

import java.util.Objects;

import static com.example.contract.constants.DomainConstants.*;
import static com.example.exceptions.DomainValidationException.ValidationErrorDetails.of;

/*
 *
 *
 * item category is required category
 * rating value should be positive (optional value)
 *
 *
 * validation flow...
 * case: if request has an invalid details
 *      1- notify the executor of this functional that something wrong happened.
 *      2- stop the execution so that no records will be persisted, removed to db.
 *
 * case: if request has no issues then execution will proceed with no interruptions
 *
 *
 * throwing exception...
 * */

public class CreateItemRequestValidator extends RequestValidator {

    protected void validateRatingValueRange(CreateItemRequest createItemRequest) {

        if(!Objects.isNull(createItemRequest.getRating())
                && (createItemRequest.getRating() <= 0 || createItemRequest.getRating() > 5)){
            validationErrors.add(of(RATING_FIELD_NAME, INVALID_RATING_VALUE_RANGE));
        }
    }

    protected void validateCategory(CreateItemRequest createItemRequest){
        if (Objects.isNull(createItemRequest.getCategory())) {
            validationErrors.add(of(CATEGORY_FIELD_NAME, VALUE_REQUIRED_ERROR_MESSAGE));
        }
    }



    @Override
    void validateSteps(Request request) {
        CreateItemRequest createItemRequest = (CreateItemRequest) request;
        validateCategory(createItemRequest);
        validateRatingValueRange(createItemRequest);
    }
}
