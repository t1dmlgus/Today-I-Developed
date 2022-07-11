package com.t1dmlgus.ordermvp.persistence.item;


import com.t1dmlgus.ordermvp.service.item.ItemCommand;
import com.t1dmlgus.ordermvp.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;
    private final ItemDtoMapper itemDtoMapper;


    @PostMapping("/api/v1/items")
    public void registerItem(@RequestBody ItemDto.RegisterItemRequest request) {

        log.info("ItemDto {}",request);

        log.info(">>>> mapper 적용 후");
        var itemCommand = itemDtoMapper.of(request);
        System.out.println("itemCommand = " + itemCommand);

        itemService.registerItem(itemCommand);

    }
}
