package com.hana.bankai.domain.user.controller;

import com.hana.bankai.domain.user.dto.RefreshToken;
import com.hana.bankai.domain.user.dto.UserRequestDto;
import com.hana.bankai.domain.user.dto.UserResponseDto;
import com.hana.bankai.domain.user.service.TokenService;
import com.hana.bankai.domain.user.service.UserService;
import com.hana.bankai.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final TokenService tokenService;
    private final UserService userService;

    /* redis test code */

    @PostMapping
    public RefreshToken createUser(@RequestBody RefreshToken user) {
        return tokenService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<RefreshToken> getUser(@PathVariable String id) {
        return tokenService.findById(id);
    }

    /* register */

    @Operation(summary = "회원가입 여부 확인")
    @PostMapping("/register/check")
    public ApiResponse<UserResponseDto.RegisterDuplicateCheck> registerCheck(@RequestBody UserRequestDto.RegisterCheck request) {
        return userService.registerCheck(request);
    }

    @Operation(summary = "이메일 중복 여부 확인")
    @PostMapping("/register/check-email")
    public ApiResponse<UserResponseDto.RegisterDuplicateCheck> registerCheckEmail(@RequestBody UserRequestDto.RegisterCheckEmail request) {
        return userService.registerCheckEmail(request);
    }

    @Operation(summary = "아이디 중복 여부 확인")
    @PostMapping("/register/check-id")
    public ApiResponse<UserResponseDto.RegisterDuplicateCheck> registerCheckId(@RequestBody UserRequestDto.RegisterCheckId request) {
        return userService.registerCheckId(request);
    }

    @Operation(summary = "회원가입")
    @PostMapping("/register")
    public ApiResponse<Object> register(@RequestBody UserRequestDto.Register request) {
        return userService.register(request);
    }


}