package com.agile.poker.controller;

import com.agile.poker.request.SigninRequest;
import com.agile.poker.request.SignupRequest;
import com.agile.poker.response.ApiResponse;
import com.agile.poker.response.JWTAuthResponse;
import com.agile.poker.security.AuthService;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.LOGIN)
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping(Endpoints.SIGNUP)
    public ResponseEntity<ApiResponse<JWTAuthResponse>> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(new ApiResponse<>(authService.signup(request)));
    }

    @PostMapping(Endpoints.SIGNIN)
    public ResponseEntity<ApiResponse<JWTAuthResponse>> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(new ApiResponse<>(authService.signin(request)));
    }
}
