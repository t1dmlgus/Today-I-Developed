package com.t1dmlgus.ordermvp.service.member;


import com.t1dmlgus.ordermvp.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfo {

    private final Long id;
    private final String username;
    private final String email;
    private final String role;

    @Builder
    private MemberInfo(Long id, String username, String email, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public static MemberInfo of(Member member) {
        return MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .role(member.getRole().toString())
                .build();
    }
}
