package com.t1dmlgus.ordermvp.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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


    //    @Enumerated(EnumType.STRING)
//    public OptionType optionType;
//
//
//    @Getter
//    @RequiredArgsConstructor
//    public enum OptionType{
//        COLOR("색상"), SIZE("사이즈");
//        private final String description;
//    }
}
