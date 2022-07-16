package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemOption;
import com.t1dmlgus.ordermvp.domain.item.ItemOptionGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class ItemInfo {

    private final String itemId;
    private final String itemName;
    private final Long itemPrice;
    private final Long memberId;

    private final List<ItemOptionGroupInfo> itemOptionGroupInfos;

    @Builder
    public ItemInfo(String itemId, String itemName, Long itemPrice, Long memberId, List<ItemOptionGroupInfo> itemOptionGroupInfos) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.memberId = memberId;
        this.itemOptionGroupInfos = itemOptionGroupInfos;
    }

    public static ItemInfo of(Item item) {
        return ItemInfo.builder()
                .itemId(String.valueOf(item.getId()))
                .itemName(item.getItemName())
                .itemPrice(item.getItemPrice())
                .memberId(item.getMember().getId())
                .itemOptionGroupInfos(ItemOptionGroupInfo.toItemOptionGroupInfos(item.getItemOptionGroups()))
                .build();
    }


    @ToString
    @Getter
    public static class ItemOptionGroupInfo{

        private final String itemOptionGroupName;
        private final List<ItemOptionInfo> itemOptionInfos;


        public ItemOptionGroupInfo(ItemOptionGroup itemOptionGroup) {
            this.itemOptionGroupName = itemOptionGroup.getItemOptionGroupName();
            this.itemOptionInfos = ItemOptionInfo.toItemOptionInfos(itemOptionGroup.getItemOptions());
        }

        public static List<ItemOptionGroupInfo> toItemOptionGroupInfos(List<ItemOptionGroup> itemOptionGroups) {

            return itemOptionGroups.stream()
                    .map(ItemOptionGroupInfo::new)
                    .collect(Collectors.toList());
        }
    }


    @ToString
    @Getter
    public static class ItemOptionInfo{

        private final String itemOptionName;
        private final String itemOptionPrice;

        public ItemOptionInfo(ItemOption i) {
            itemOptionName = i.getItemOptionName();
            itemOptionPrice = String.valueOf(i.getItemOptionPrice());
        }


        public static List<ItemOptionInfo> toItemOptionInfos(List<ItemOption> itemOptions) {
            return itemOptions.stream()
                    .map(ItemOptionInfo::new)
                    .collect(Collectors.toList());
        }
    }

}
