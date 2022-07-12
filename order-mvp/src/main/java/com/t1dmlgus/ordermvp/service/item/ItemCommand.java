package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemOption;
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
            List<ItemOptionGroup> collect = itemOptionGroupRequestList.stream()
                    .map(RegisterItemOptionGroupRequest::toItemOptionGroupEntity)
                    .collect(Collectors.toList());

            //  return Item.newInstance(itemName, itemPrice, collect);
            return new Item(itemName, itemPrice, collect);
        }
    }

    @ToString
    @Getter
    @Builder
    public static class RegisterItemOptionGroupRequest {

        private final String itemOptionGroupName;
        private final List<RegisterItemOptionRequest> itemOptionRequestList;

        ItemOptionGroup toItemOptionGroupEntity(){
            List<ItemOption> collect = itemOptionRequestList.stream()
                    .map(i -> new ItemOption(i.itemOptionName, Long.valueOf(i.itemOptionPrice)))
                    .collect(Collectors.toList());

            return new ItemOptionGroup(itemOptionGroupName, collect);
        }

    }

    @ToString
    @Getter
    @Builder
    public static class RegisterItemOptionRequest {

        private final String itemOptionPrice;
        private final String itemOptionName;

    }

}
