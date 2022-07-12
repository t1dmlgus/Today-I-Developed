package com.t1dmlgus.ordermvp.persistence.item;

import lombok.Getter;
import lombok.ToString;

import java.util.List;


public class ItemDto {

    @ToString
    @Getter
    public static class RegisterItemRequest{
        private String itemName;
        private String itemPrice;
        private List<RegisterItemOptionGroup> itemOptionGroupList;
    }

    @ToString
    @Getter
    public static class RegisterItemOptionGroup {

        private List<RegisterItemOption> itemOptionList;
        private String itemOptionGroupName;
    }

    @ToString
    @Getter
    public static class RegisterItemOption {

        private String itemOptionPrice;
        private String itemOptionName;
    }

}
