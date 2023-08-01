package com.agile.poker.service;

import com.agile.poker.entity.Users;

import java.util.UUID;

public interface EncryptPass {
    /**
        Recibe el password del usuario y lo encripta
     */
    Users encryptPassword(Users users);
    /**
        Comprueba si la contraseña encriptada se corresponde con la contraseña original
     */
    boolean verifyPassword(String originalPassword, String hasPassword);
}
