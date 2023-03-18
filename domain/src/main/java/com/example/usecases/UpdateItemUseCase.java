package com.example.usecases;

import com.example.contract.repositories.ItemsRepository;
import com.example.contract.requests.UpdateItemRequest;
import com.example.contract.responses.ItemResponse;
import com.example.mappers.ItemDomainMapper;
import com.example.modals.Item;
import com.example.validators.CreateItemRequestValidator;

import java.time.LocalDateTime;

public class UpdateItemUseCase {

    private final ItemDomainMapper itemDomainMapper;
    private final CreateItemRequestValidator itemRequestValidator;
    private final ItemsRepository itemsRepository;

    public UpdateItemUseCase(ItemDomainMapper itemDomainMapper, CreateItemRequestValidator itemRequestValidator, ItemsRepository itemsRepository) {
        this.itemDomainMapper = itemDomainMapper;
        this.itemRequestValidator = itemRequestValidator;
        this.itemsRepository = itemsRepository;
    }

    public ItemResponse execute(UpdateItemRequest request){
        itemRequestValidator.validate(request);

        Item item = itemDomainMapper.toDomain(request);

        initializeSystemValues(item);

        Item returned = itemsRepository.save(item);

        return itemDomainMapper.toCreateResponse(returned);
    }

    private void initializeSystemValues(Item item){
        item.setUpdateDateTime(LocalDateTime.now());
    }


}
