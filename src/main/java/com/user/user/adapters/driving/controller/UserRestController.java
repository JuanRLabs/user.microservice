package com.user.user.adapters.driving.controller;

import com.user.user.adapters.driving.dto.AddUserAssistant;
import com.user.user.adapters.driving.mapper.IUserRequestMapper;
import com.user.user.domain.api.IUserServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @PostMapping("/saveUser")
    public ResponseEntity<Void> saveUser(@Valid @RequestBody AddUserAssistant addUserAssistant){
        userServicePort.createAssistantWarehouse(userRequestMapper.toModel(addUserAssistant));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
