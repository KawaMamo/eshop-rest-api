package com.example;

import com.example.contract.repositories.ItemsRepository;
import com.example.contract.requests.CreateItemRequest;
import com.example.contract.requests.DeleteRequest;
import com.example.contract.requests.UpdateItemRequest;
import com.example.exceptions.DomainValidationException;
import com.example.mappers.ItemDomainMapperImpl;
import com.example.modals.ItemCategory;
import com.example.modals.ItemUnit;
import com.example.repositories.InMemoryItemsRepository;
import com.example.simulators.DependencyInjector;
import com.example.usecases.CreateItemUseCase;
import com.example.usecases.DeleteItemUseCase;
import com.example.usecases.UpdateItemUseCase;
import com.example.validators.CreateItemRequestValidator;
import com.example.validators.DeleteRequestValidator;
import com.example.validators.UpdateItemRequestValidator;

public class Main {
    public static void main(String[] args) {
        System.setProperty("repository-mode", "inMemory");

        CreateItemUseCase createItemUseCase = DependencyInjector.getBean(CreateItemUseCase.class);
        InMemoryItemsRepository bean = (InMemoryItemsRepository) DependencyInjector.getBean(ItemsRepository.class);

        //restAPI request body...
        CreateItemRequest createItemRequest = new CreateItemRequest();
        createItemRequest.setName("laptop dell");
        createItemRequest.setCategory(ItemCategory.IT);
        createItemRequest.setRating(5);
        createItemRequest.setIsInStock(true);
        createItemRequest.setUnit(ItemUnit.PIECE);

        //api exception handler...
        try {
            createItemUseCase.execute(createItemRequest);
            createItemUseCase.execute(createItemRequest);

            System.out.println(bean.listAll());
        } catch (DomainValidationException e) {
            System.out.println(e.getValidationErrors());
        }

        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setId(1L);
        updateItemRequest.setName("MSI Laptop");
        updateItemRequest.setCategory(ItemCategory.IT);
        updateItemRequest.setRating(4);
        updateItemRequest.setIsInStock(true);
        updateItemRequest.setUnit(ItemUnit.PIECE);

        UpdateItemUseCase updateItemUseCase = new UpdateItemUseCase(new ItemDomainMapperImpl(),
                new UpdateItemRequestValidator(),
                bean);

        try {
            updateItemUseCase.execute(updateItemRequest);
        }catch (DomainValidationException e){
            System.out.println(e.getValidationErrors());
        }


        System.out.println(bean.listAll());

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setId(1L);
        DeleteRequestValidator deleteRequestValidator = new DeleteRequestValidator();
        DeleteItemUseCase deleteItemUseCase = new DeleteItemUseCase(deleteRequestValidator, bean, new ItemDomainMapperImpl());
        deleteItemUseCase.execute(deleteRequest);

        System.out.println(bean.listAll());
    }
}