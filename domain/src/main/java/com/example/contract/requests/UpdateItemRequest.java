package com.example.contract.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UpdateItemRequest extends CreateItemRequest{
    private Long id;
}
