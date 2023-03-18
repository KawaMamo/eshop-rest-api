package com.example.usecases;

import com.example.contract.repositories.ItemsRepository;
import com.example.contract.requests.DeleteRequest;
import com.example.contract.requests.Request;
import com.example.contract.responses.ItemResponse;
import com.example.mappers.ItemDomainMapper;
import com.example.modals.Item;
import com.example.validators.DeleteRequestValidator;

public class DeleteItemUseCase {

    private final DeleteRequestValidator deleteRequestValidator;
    private final ItemsRepository itemsRepository;
    private final ItemDomainMapper itemDomainMapper;

    public DeleteItemUseCase(DeleteRequestValidator deleteRequestValidator,
                             ItemsRepository itemsRepository,
                             ItemDomainMapper itemDomainMapper) {
        this.deleteRequestValidator = deleteRequestValidator;
        this.itemsRepository = itemsRepository;
        this.itemDomainMapper = itemDomainMapper;
    }

    public ItemResponse execute(Request request){
        deleteRequestValidator.validate(request);
        Item deletedItem = itemsRepository.delete(((DeleteRequest)request).getId());
        return itemDomainMapper.toCreateResponse(deletedItem);
    }
}
