package com.SpringTest.SpringTest.member.mapper;

import com.SpringTest.SpringTest.member.dto.MemberPatchDto;
import com.SpringTest.SpringTest.member.dto.MemberPostDto;
import com.SpringTest.SpringTest.member.dto.MemberResponseDto;
import com.SpringTest.SpringTest.member.entity.Member;
import org.springframework.stereotype.Component;

@Component //O (1)
public class MemberMapper {
    //O (2) MemberPostDto를 Member로 변환
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        return new Member(0L, memberPostDto.getEmail(),
                memberPostDto.getName(),
                memberPostDto.getPhone());
    }

    //O (3) MemberPatchDto를 Member로 변환
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        return new Member(memberPatchDto.getMemberId(),
                null,
                memberPatchDto.getName(),
                memberPatchDto.getPhone());
    }

    //O (4) Member를 MemberResponseDto로 변환
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        return new MemberResponseDto(member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getPhone());
    }
}
