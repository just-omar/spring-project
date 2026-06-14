package com.example.demo.mapper;

import com.example.demo.dto.UserResponse;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(UserEntity request) {
        if (request == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        return entity;
    }

    public UserResponse toResponse(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        return response;
    }
}
