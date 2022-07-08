package com.t1dmlgus.ordermvp.service.member;

import com.t1dmlgus.ordermvp.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberCommand {

    private String username;
    private String email;
    private String password;


    public Member toEntity(){
        return Member.newInstance(username, email, password);
    }


}
