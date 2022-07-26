package com.SpringTest.SpringTest.member.service;

import com.SpringTest.SpringTest.exception.BusinessLogicException;
import com.SpringTest.SpringTest.exception.ExceptionCode;
import com.SpringTest.SpringTest.member.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        // TODO should business logic

        // O member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        // O member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        // TODO should business logic

        // O member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
//        Member member = new Member(memberId, "ym24319577@gmail.com", "최영민", "010-2431-9577");
//        return member;
        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    public List<Member> findMembers() {
        // TODO should business logic

        // O member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        List<Member> members = List.of(
                new Member(1, "ym24319577@gmail.com", "최영민", "010-2431-9577"),
                new Member(2, "yn9577@naver.com", "최영민2", "010-2431-9587")
        );
        return members;
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

        String logResult = null;
        System.out.println(logResult.toUpperCase());
    }
}
