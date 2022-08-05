package dev.t1dmlgus.springBatchEx.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Level level = Level.NORMAL;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Orders> orders;

    private LocalDate updateDate;

    @Builder
    public User(String username, List<Orders> orders) {
        this.username = username;
        this.orders = orders;
    }

    public boolean availableLevelUp() {
        return Level.availableLevelUp(this.getLevel(), this.getTotalAmount());
    }

    private int getTotalAmount() {
        return this.orders.stream()
                .mapToInt(Orders::getAmount)
                .sum();
    }


    @Getter
    @RequiredArgsConstructor
    private enum Level {
        VIP(500_000, null),
        GOLD(500_000, VIP),
        SILVER(300_000, GOLD),
        NORMAL(200_000, SILVER);

        private final int nextAmount;
        private final Level nextLevel;


        public static boolean availableLevelUp(Level level, int totalAmount) {

            if (Objects.isNull(level)) {
                return false;
            }
            // VIP
            if (Objects.isNull(level.nextLevel)) {
                return false;
            }
            return totalAmount >= level.nextAmount;
        }


        private static Level getNextLevel(int totalAmount) {

            if (totalAmount >= Level.VIP.nextAmount) {
                return VIP;
            }
            if (totalAmount >= Level.GOLD.nextAmount) {
                return GOLD.nextLevel;
            }
            if (totalAmount >= Level.SILVER.nextAmount) {
                return SILVER.nextLevel;
            }
            if (totalAmount >= Level.NORMAL.nextAmount) {
                return NORMAL.nextLevel;
            }

            return NORMAL;
        }

    }

    public Level levelUp(){

        Level nextLevel = Level.getNextLevel(this.getTotalAmount());

        this.level = nextLevel;
        this.updateDate = LocalDate.now();

        return nextLevel;
    }
}