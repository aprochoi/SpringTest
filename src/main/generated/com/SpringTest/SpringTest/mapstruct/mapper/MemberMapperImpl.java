package com.SpringTest.SpringTest.mapstruct.mapper;

import com.SpringTest.SpringTest.member.dto.MemberPatchDto;
import com.SpringTest.SpringTest.member.dto.MemberPostDto;
import com.SpringTest.SpringTest.member.dto.MemberResponseDto;
import com.SpringTest.SpringTest.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-15T17:48:24+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostDto.getEmail() );
        member.setName( memberPostDto.getName() );
        member.setPhone( memberPostDto.getPhone() );

        return member;
    }

    @Override
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( memberPatchDto.getMemberId() );
        member.setEmail( memberPatchDto.getEmail() );
        member.setName( memberPatchDto.getName() );
        member.setPhone( memberPatchDto.getPhone() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String email = null;
        String name = null;
        String phone = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        name = member.getName();
        phone = member.getPhone();

        MemberResponseDto memberResponseDto = new MemberResponseDto( memberId, email, name, phone );

        return memberResponseDto;
    }
}
