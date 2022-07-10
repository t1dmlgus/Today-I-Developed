package com.t1dmlgus.ordermvp.persistence.item;


import com.t1dmlgus.ordermvp.service.item.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService service) {
        this.itemService = service;
    }


    @PostMapping("/api/v1/items")
    public void registerItem(@RequestBody ItemDto ItemDto) {

        log.info("ItemDto {}",ItemDto);

//        itemService.registerItem(itemCommand);

    }
}
