package com.example.contract.requests;

import com.example.modals.ItemCategory;
import com.example.modals.ItemUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.money.Money;

import java.util.List;

@Data
@EqualsAndHashCode
public class CreateItemRequest extends Request{
    private String name;
    private ItemCategory category;
    private Boolean isInStock;
    private Integer rating;
    private ItemUnit unit;
    private Money price;
    private List<DocumentCreateRequest> pictures;

}
