package com.t1dmlgus.ordermvp.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "item")
@NoArgsConstructor
@Getter
@Entity
public class ItemOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemOptionGroupName;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemOptionGroup")
    private List<ItemOption> itemOptions = new ArrayList<>();

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemOptionGroup(String itemOptionGroupName, List<ItemOption> itemOptions) {

        this.itemOptionGroupName = itemOptionGroupName;
        this.itemOptions = itemOptions;

        // 연관관계 추가
        addItemOption(itemOptions);
    }

    private void addItemOption(List<ItemOption> itemOptions) {
        for (ItemOption itemOption : itemOptions) {
            itemOption.setItemOptionGroup(this);
        }
    }
}
