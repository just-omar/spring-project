package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Указывает Spring, что это компонент бизнес-логики
@RequiredArgsConstructor // Lombok автоматически внедрит репозиторий и маппер через конструктор
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserRequest request){
        UserEntity userEntity = new UserEntity();
        return userRepository.save(userEntity);
    }
}
