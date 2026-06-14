package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @Email(message = "Неверный формат email")
    @NotBlank(message = "Email обязателен")
    private String email;
}
