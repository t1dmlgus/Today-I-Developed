package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemOptionGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class ItemCommand {
    @ToString
    @Getter
    @Builder
    public static class RegisterItemRequest{
        private final String itemName;
        private final Long itemPrice;

        private final List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList;

        public Item toEntity(){

            itemOptionGroupRequestList.stream()
                    .map(i -> new RegisterItemOptionGroupRequest(i.itemOptionGroupName, i.itemOptionRequestList))
                    .collect(Collectors.toList());

//            return Item.newInstance(itemName, itemPrice, collect);
            return null;
        }
    }

    @ToString
    @Getter
    @Builder
    public static class RegisterItemOptionGroupRequest {

        private final String itemOptionGroupName;
        private final List<RegisterItemOptionRequest> itemOptionRequestList;
    }

    @ToString
    @Getter
    @Builder
    public static class RegisterItemOptionRequest {

        private final String itemOptionPrice;
        private final String itemOptionName;

    }

}
