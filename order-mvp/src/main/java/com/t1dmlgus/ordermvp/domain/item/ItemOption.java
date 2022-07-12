package com.t1dmlgus.ordermvp.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@ToString(exclude = "itemOptionGroup")
@NoArgsConstructor
@Getter
@Entity
public class ItemOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemOptionName;
    private Long itemOptionPrice;

    @ManyToOne
    @JoinColumn(name = "itemOptionGroup_id")
    private ItemOptionGroup itemOptionGroup;

    public ItemOption(String itemOptionName, Long itemOptionPrice) {

        this.itemOptionName = itemOptionName;
        this.itemOptionPrice = itemOptionPrice;
    }

    public void setItemOptionGroup(ItemOptionGroup itemOptionGroup) {
        this.itemOptionGroup = itemOptionGroup;
    }
}
