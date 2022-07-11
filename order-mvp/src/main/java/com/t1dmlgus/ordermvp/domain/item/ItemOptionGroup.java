package com.t1dmlgus.ordermvp.domain.item;

import com.t1dmlgus.ordermvp.service.item.ItemCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public ItemOptionGroup(String itemOptionGroupName, List<ItemCommand.RegisterItemOptionRequest> itemOptionRequestList) {

        List<ItemOption> collect = itemOptionRequestList.stream()
                .map(i -> new ItemOption(i.getItemOptionName(), Long.valueOf(i.getItemOptionPrice())))
                .collect(Collectors.toList());
        this.itemOptionGroupName = itemOptionGroupName;
        this.itemOptions = collect;

    }
}
