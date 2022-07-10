package com.t1dmlgus.ordermvp.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


}
