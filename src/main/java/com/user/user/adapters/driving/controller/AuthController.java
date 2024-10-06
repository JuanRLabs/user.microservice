package com.user.user.adapters.driving.controller;

import com.user.user.adapters.driving.dto.request.LoginRequestDto;
import com.user.user.adapters.driving.dto.response.JwtResponseDto;
import com.user.user.adapters.driving.handler.Impl.AuthHandlerImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthHandlerImpl authHandler;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return new ResponseEntity<>(authHandler.login(loginRequestDto), HttpStatus.OK);
    }
}
