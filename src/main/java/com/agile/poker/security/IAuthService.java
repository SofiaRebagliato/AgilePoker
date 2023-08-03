package com.agile.poker.security;

import com.agile.poker.request.SigninRequest;
import com.agile.poker.request.SignupRequest;
import com.agile.poker.response.JWTAuthResponse;

public interface IAuthService {

    JWTAuthResponse signup(SignupRequest request);
    JWTAuthResponse signin(SigninRequest request);
}
