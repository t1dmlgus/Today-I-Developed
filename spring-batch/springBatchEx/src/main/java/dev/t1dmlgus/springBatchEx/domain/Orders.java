package dev.t1dmlgus.springBatchEx.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private int amount;
    private LocalDate createDate;


    @Builder
    public Orders(String itemName, int amount, LocalDate createDate) {
        this.itemName = itemName;
        this.amount = amount;
        this.createDate = createDate;
    }
}
