package com.agile.poker.service.impl;

import com.agile.poker.entity.Users;
import com.agile.poker.repository.UsersRepository;
import com.agile.poker.service.EncryptPass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class EncryptPassImpl implements EncryptPass {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users encryptPassword(Users user) {
        String encryptedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(encryptedPass);
        return user;
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hasPassword) {
        return false;
    }
}
