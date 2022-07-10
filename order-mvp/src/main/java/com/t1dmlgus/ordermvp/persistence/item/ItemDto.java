package com.t1dmlgus.ordermvp.persistence.item;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ItemDto {

    private String itemName;
    private String itemPrice;
    private List<ItemOptionGroup> itemOptionGroups;

    @ToString
    @Getter
    public static class ItemOptionGroup {

        private List<ItemOption> itemOptions;
        private String itemOptionGroupName;
    }

    @ToString
    @Getter
    public static class ItemOption {

        private String itemOptionPrice;
        private String itemOptionName;
    }
}
