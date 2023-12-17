package com.codingrecipe.member.repository;

import com.codingrecipe.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // 이메일로 회원 정보 조회 (select * from member_table where member_email=?)
    // 인터페이스는 추상 메서드
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
    //Optional : null 방지
}
