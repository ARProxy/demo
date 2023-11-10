package com.example.controller;

import com.example.dto.MemberRequestDto;
import com.example.dto.MemberResponseDto;
import com.example.dto.TokenDto;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @RequestMapping("/api/user/signup")
    public ResponseEntity<MemberResponseDto> sighup(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto memberResponseDto = authService.signup(requestDto);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @RequestMapping("/api/user/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        TokenDto tokenDto = authService.login(requestDto);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }
}
