package com.t1dmlgus.ordermvp.domain.member;

import com.t1dmlgus.ordermvp.domain.AbstractEntity;
import com.t1dmlgus.ordermvp.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static Member newInstance(String username, String email, String password) {
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(Role.USER)
                .build();
    }


    @Getter
    @RequiredArgsConstructor
    public enum Role{
        USER("유저"), ADMIN("관리자");
        private final String description;
    }


}
