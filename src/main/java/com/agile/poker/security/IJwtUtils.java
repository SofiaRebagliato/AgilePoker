package com.agile.poker.security;

import com.agile.poker.entity.Users;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public interface IJwtUtils {
    public String extractUserName(String token);
    public String getToken(Users user);
    public Boolean isTokenValid(String token, Users user);
}
