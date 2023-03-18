package com.example.contract.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class DeleteRequest extends Request{
    private Long id;
}
