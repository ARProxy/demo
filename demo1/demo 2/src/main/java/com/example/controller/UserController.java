package com.example.controller;

import com.example.entity.UsersEntity;
import com.example.dto.TokenResponse;
import com.example.dto.UserRequest;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signUp")
    public ResponseEntity signUp(@RequestBody UserRequest userRequest) {
        return userService.findByUserId(userRequest.getUserId()).isPresent()
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(userService.signUp(userRequest));
    }

    @PostMapping("/user/signIn")
    public ResponseEntity<TokenResponse> signIn(@RequestBody UserRequest userRequest) {

        return ResponseEntity.ok().body(userService.signIn(userRequest));
    }

    @GetMapping("/info")
    public ResponseEntity<List<UsersEntity>> findUser() {
        return ResponseEntity.ok().body(userService.findUsers());
    }
}
