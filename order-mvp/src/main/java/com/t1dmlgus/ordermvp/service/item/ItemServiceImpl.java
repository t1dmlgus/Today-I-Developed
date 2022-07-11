package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void registerItem(ItemCommand.RegisterItemRequest itemCommand) {

        var item = itemCommand.toEntity();
        Item save = itemRepository.save(item);

        System.out.println("save = " + save);
    }



}
