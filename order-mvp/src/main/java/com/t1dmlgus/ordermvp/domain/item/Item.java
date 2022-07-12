package com.t1dmlgus.ordermvp.domain.item;

import com.t1dmlgus.ordermvp.domain.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
@Entity
public class Item extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Long itemPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<ItemOptionGroup> itemOptionGroups = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        READY_FOR_SALE("판매준비중"),
        SALE("판매중"),
        END_OF_SALE("판매종료");

        private final String description;
    }

    @Builder
    public Item(String itemName, Long itemPrice, List<ItemOptionGroup> itemOptionGroups) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemOptionGroups = itemOptionGroups;
        this.status = Status.READY_FOR_SALE;

        // 연관관계 추가
        addItemOptionGroup(itemOptionGroups);
    }

    private void addItemOptionGroup(List<ItemOptionGroup> itemOptionGroups) {
        for (ItemOptionGroup itemOptionGroup : itemOptionGroups) {
            itemOptionGroup.setItem(this);
        }
    }




    public static Item newInstance(String itemName, Long itemPrice, List<ItemOptionGroup> itemOptionGroups){
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemOptionGroups(itemOptionGroups)
                .build();
    }
}
