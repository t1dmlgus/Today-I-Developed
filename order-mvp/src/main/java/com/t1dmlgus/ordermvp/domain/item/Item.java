package com.t1dmlgus.ordermvp.domain.item;

import com.t1dmlgus.ordermvp.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<ItemOptionGroup> ItemOptionGroups = new ArrayList<>();

    @Builder
    private Item(String itemName, Long itemPrice, List<ItemOptionGroup> ItemOptionGroups) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.ItemOptionGroups = ItemOptionGroups;
    }

    public static Item newInstance(String itemName, Long itemPrice, List<ItemOptionGroup> ItemOptionGroups){
        return Item.builder()
                .itemName(itemName)
                .itemPrice(itemPrice)
                .ItemOptionGroups(ItemOptionGroups)
                .build();
    }
}
