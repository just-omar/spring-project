package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping// Принимает GET-запросы на http://localhost:8080/api/users
    public List<UserResponse> findAll() {
        return userService.getAllUsers().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @PostMapping// Принимает POST-запросы на http://localhost:8080/api/users
    public UserResponse create(@Valid @RequestBody UserRequest userRequest) {
        // Вызываем сервис, а результат маппим в безопасный DTO ответа
        return userMapper.toResponse(userService.createUser(userRequest));
    }
}
