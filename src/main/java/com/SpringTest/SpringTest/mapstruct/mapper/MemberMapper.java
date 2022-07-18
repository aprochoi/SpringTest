package com.SpringTest.SpringTest.mapstruct.mapper;

import com.SpringTest.SpringTest.member.dto.MemberPatchDto;
import com.SpringTest.SpringTest.member.dto.MemberPostDto;
import com.SpringTest.SpringTest.member.dto.MemberResponseDto;
import com.SpringTest.SpringTest.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
