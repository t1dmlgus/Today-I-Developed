package com.t1dmlgus.ordermvp.domain.member;

import com.t1dmlgus.ordermvp.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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
    private Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
    }

    public static Member newInstance(String username, String email, String password) {
        return new Member(username, email, password);
    }


    @Getter
    @RequiredArgsConstructor
    public enum Role{
        USER("유저"), ADMIN("관리자");
        private final String description;
    }


}
