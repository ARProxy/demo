package com.example.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenResponse {
    private String ACCESS_TOKEN;
    private String REFRESH_TOKEN;
}