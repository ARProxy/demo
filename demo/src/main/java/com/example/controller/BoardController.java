package com.example.controller;

import com.example.dto.BoardDto;
import com.example.dto.MemberRequestDto;
import com.example.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    @RequestMapping("/api/board/my")
    public ResponseEntity<BoardDto> my() {
        return null;
    }

    @RequestMapping("/api/board/category")
    public ResponseEntity<BoardDto> category() {
        return null;
    }
    @RequestMapping("/api/board/myCategory")
    public ResponseEntity<BoardDto> myCategory() {
        return null;
    }
    @RequestMapping("/api/board/insertCategory")
    public ResponseEntity<BoardDto> insertCategory() {
        return null;
    }
    @RequestMapping("/api/board/skin")
    public ResponseEntity<BoardDto> skin() {
        return null;
    }
    @RequestMapping("/api/board/selectSkin")
    public ResponseEntity<BoardDto> selectSkin() {
        return null;
    }
    @RequestMapping("/api/board/save")
    public ResponseEntity<BoardDto> save() {
        return null;
    }
    @RequestMapping("/api/board/share")
    public ResponseEntity<BoardDto> share() {
        return null;
    }
}
