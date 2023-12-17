package com.codingrecipe.member.service;

import com.codingrecipe.member.entity.MemberEntity;
import com.codingrecipe.member.repository.MemberRepository;

public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberEntity Login(String memberEmail, String memberPassword){

        return memberRepository.findByMemberEmail(memberEmail)
                .filter(m -> m.getMemberPassword().equals(memberPassword))
                .orElse(null);
    }
}
