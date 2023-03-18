package com.example.repositories;

import com.example.contract.repositories.ItemsRepository;
import com.example.modals.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryItemsRepository implements ItemsRepository {

    private Map<Long, Item> itemsTable = new HashMap<>();

    @Override
    public Item save(Item item) {

        if(item.getId() == null){
            Long nextVal = itemsTable.keySet()
                    .stream()
                    .max(Long::compareTo)
                    .orElse(0L) + 1;
            item.setId(nextVal);
        }

        return itemsTable.put(item.getId(), item);
    }

    @Override
    public Item delete(Long id) {
        return itemsTable.remove(id);
    }

    public List<Item> listAll() {
        return new ArrayList<>(itemsTable.values());
    }

}
