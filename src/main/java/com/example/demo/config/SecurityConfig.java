package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Отключаем CSRF, так как мы пишем REST API для внешних клиентов
                .csrf(AbstractHttpConfigurer::disable)

                // Настраиваем правила для путей
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Все запросы требуют авторизации Basic Auth
                )

                // Включаем поддержку стандартной Basic авторизации (для Insomnia)
                .httpBasic(Customizer.withDefaults())

                // Переводим сессии в режим Stateless (сервер больше не запоминает браузеры)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}
