package com.t1dmlgus.ordermvp.service.item;


import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemOptionGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ItemCommand {

    private final String itemName;
    private final Long itemPrice;

    private final List<ItemOptionGroup> ItemOptionGroups;

    @Builder
    public ItemCommand(String itemName, Long itemPrice, List<ItemOptionGroup> ItemOptionGroups) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.ItemOptionGroups = ItemOptionGroups;
    }

    public Item toEntity() {
        return Item.newInstance(itemName, itemPrice, ItemOptionGroups);
    }
}
