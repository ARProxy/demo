package com.example.dto;

import com.example.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {

    private String userid;
    private String nickname;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .userid(member.getUserid())
                .nickname(member.getNickname())
                .build();
    }
}
