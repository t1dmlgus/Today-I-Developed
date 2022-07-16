package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemOption;
import com.t1dmlgus.ordermvp.domain.item.ItemOptionGroup;
import com.t1dmlgus.ordermvp.domain.member.Member;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class ItemCommand {
    @ToString
    @Getter
    public static class RegisterItemRequest{
        private final String itemName;
        private final Long itemPrice;
        private final Long memberId;

        private final List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList;

        public RegisterItemRequest(String itemName, Long itemPrice, Long memberId, List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.memberId = memberId;
            this.itemOptionGroupRequestList = itemOptionGroupRequestList;
        }

        public Item toItem(Member member){
            List<ItemOptionGroup> itemOptionGroups = itemOptionGroupRequestList.stream()
                    .map(RegisterItemOptionGroupRequest::toItemOptionGroup)
                    .collect(Collectors.toList());

              return Item.newInstance(itemName, itemPrice, member, itemOptionGroups);
        }
    }

    @ToString
    @Getter
    public static class RegisterItemOptionGroupRequest {

        private final String itemOptionGroupName;
        private final List<RegisterItemOptionRequest> itemOptionRequestList;

        public RegisterItemOptionGroupRequest(String itemOptionGroupName, List<RegisterItemOptionRequest> itemOptionRequestList) {
            this.itemOptionGroupName = itemOptionGroupName;
            this.itemOptionRequestList = itemOptionRequestList;
        }

        ItemOptionGroup toItemOptionGroup(){
            List<ItemOption> collect = itemOptionRequestList.stream()
                    .map(i -> new ItemOption(i.itemOptionName, Long.valueOf(i.itemOptionPrice)))
                    .collect(Collectors.toList());

            return new ItemOptionGroup(itemOptionGroupName, collect);
        }

    }

    @ToString
    @Getter
    public static class RegisterItemOptionRequest {

        private final String itemOptionPrice;
        private final String itemOptionName;

        public RegisterItemOptionRequest(String itemOptionPrice, String itemOptionName) {
            this.itemOptionPrice = itemOptionPrice;
            this.itemOptionName = itemOptionName;
        }
    }

}
