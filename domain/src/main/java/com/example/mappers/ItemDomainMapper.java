package com.example.mappers;

import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.UpdateItemRequest;
import com.example.contract.responses.ItemResponse;
import com.example.modals.Item;
import org.mapstruct.Mapper;

@Mapper
public interface ItemDomainMapper {

    Item toDomain(CreateItemRequest createItemRequest);

//    @Mapping(target = "name", ignore = true)
//    @Mapping(target = "responseCategory", source = "category")
//    @Mapping(target = "identifier", expression = "java(buildItemIdentifier(item.getId() , item.getName()))")
//    @Mapping(target = "identifier", constant = "ABCD")
    ItemResponse toCreateResponse(Item item);

    Item toDomain(UpdateItemRequest request);

//    default String buildItemIdentifier(Long id, String name) {
//        return id.toString().concat("#").concat(name);
//    }

}
