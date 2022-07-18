package com.SpringTest.SpringTest.member.controller;

import com.SpringTest.SpringTest.mapstruct.mapper.MemberMapper;
import com.SpringTest.SpringTest.member.dto.MemberPatchDto;
import com.SpringTest.SpringTest.member.dto.MemberPostDto;
import com.SpringTest.SpringTest.member.dto.MemberResponseDto;
import com.SpringTest.SpringTest.member.entity.Member;
//import com.SpringTest.SpringTest.member.mapper.MemberMapper;
import com.SpringTest.SpringTest.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/members")
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    //O 회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        //O (2) 매퍼를 이용해 MemberPostDto를 Member로 변환
        Member response = memberService.createMember(mapper.memberPostDtoToMember(memberPostDto));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

    //O 회원 정보 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member response = memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    //O 한명의 회원 정보 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {

        Member response = memberService.findMember(memberId);

        return new ResponseEntity(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    //O 모든 회원 정보 조회
    @GetMapping
    public ResponseEntity getMembers() {

        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> response = mapper.membersToMemberResponseDto(members);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //O 회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {

        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
