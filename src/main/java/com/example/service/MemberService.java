package com.example.service;

import com.example.config.SecurityUtil;
import com.example.dto.MemberRequestDto;
import com.example.dto.MemberResponseDto;
import com.example.entity.Member;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponseDto getMyInfoBySecurity() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없음"));
    }

    @Transactional
    public MemberResponseDto changeMemberNickname(String userid, String nickname) {
        Member member = memberRepository.findByUserid(userid).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없음"));
        member.setNickname(nickname);
        return MemberResponseDto.of(memberRepository.save(member));
    }

}
