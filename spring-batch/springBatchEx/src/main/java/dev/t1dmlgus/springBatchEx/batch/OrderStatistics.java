package dev.t1dmlgus.springBatchEx.batch;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

// 주문금액을 합산 하여 파일로 생성하는 클래스
// 일별로 주문 금액 합산

@Getter
public class OrderStatistics {

    private String amount;

    private LocalDate date;

    @Builder
    private OrderStatistics(String amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }
}
