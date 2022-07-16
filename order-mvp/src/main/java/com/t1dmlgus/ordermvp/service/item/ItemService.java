package com.t1dmlgus.ordermvp.service.item;

public interface ItemService {

    void registerItem(ItemCommand.RegisterItemRequest itemCommand);

    ItemInfo getItemDetails(Long itemId);
}
