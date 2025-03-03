package com.example.contract.responses;

import com.example.modals.Document;
import com.example.modals.ItemCategory;
import com.example.modals.ItemUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.money.Money;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
public class ItemResponse {
    private Long id;
    private String name;
    private String identifier;
    private ItemCategory responseCategory;
    private Boolean isInStock;
    private Integer rating;
    private ItemUnit unit;
    private Money price;
    private LocalDateTime creationDateTime;

    private LocalDateTime updateDateTime;
    private List<Document> pictures;

}
