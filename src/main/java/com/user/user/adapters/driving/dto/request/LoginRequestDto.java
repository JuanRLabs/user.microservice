package com.user.user.adapters.driving.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
