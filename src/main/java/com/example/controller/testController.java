package com.example.controller;

import com.example.response.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping(value = "/ex01")
    public ResponseEntity<TestResponse> test() {
        TestResponse response = new TestResponse("test 성공?");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
