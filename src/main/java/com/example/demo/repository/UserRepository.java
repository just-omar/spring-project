package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
// Наследуя JpaRepository<Тип_Сущности, Тип_Первичного_Ключа>, мы автоматически получаем методы:
// save(), findById(), findAll(), deleteById(), count() и многие другие.

}
