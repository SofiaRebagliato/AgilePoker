package com.agile.poker.security;

import com.agile.poker.entity.Users;
import com.agile.poker.exception.InvalidCredentialsException;
import com.agile.poker.repository.UsersRepository;
import com.agile.poker.request.SigninRequest;
import com.agile.poker.request.SignupRequest;
import com.agile.poker.response.JWTAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthService implements IAuthService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IJwtUtils jwtUtils;

    /**
     * Inscripción
     * @param request
     * @return
     */
    @Override
    public JWTAuthResponse signup(SignupRequest request) {
        Users user = new Users(request.getName(), request.getEmail(),
                passwordEncoder.encode(request.getPassword()));

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(user.getEmail());

        Users verifyUser;
        if (matcher.find()) {
            verifyUser = usersRepository.save(user);
        } else {
            throw new InvalidCredentialsException("El email introducido no es correcto");
        }

        String jwt = jwtUtils.getToken(verifyUser);
        return new JWTAuthResponse(jwt);
    }

    /**
     * Inicio de sesión
     * @param request
     * @return
     */
    @Override
    public JWTAuthResponse signin(SigninRequest request) {
        Users user = usersRepository.findByEmail(request.getEmail());
        String jwt = jwtUtils.getToken(user);
        return new JWTAuthResponse(jwt);
    }
}