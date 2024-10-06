package com.user.user.adapters.driving.handler;

import com.user.user.adapters.driving.dto.request.LoginRequestDto;
import com.user.user.adapters.driving.dto.response.JwtResponseDto;

public interface IAuthHandler  {
     JwtResponseDto login(LoginRequestDto loginRequestDto);
}
