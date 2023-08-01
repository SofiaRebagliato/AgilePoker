package com.agile.poker.service.impl;

import com.agile.poker.entity.Users;
import com.agile.poker.repository.PlayersRepository;
import com.agile.poker.repository.UsersRepository;
import com.agile.poker.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Users findById(UUID uuid) {
        return usersRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    @Transactional
    public boolean addUser(Users user) {
        //Comprobación de que el email introducido es válido, para poder dar de alta el usuario.
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(user.getEmail());

        if(matcher.find()) {
            usersRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public boolean deleteUser(UUID uuid) {
        //Para realizar la operación de eliminar, se debería de comprobar que el player tenga los permisos de Owner.
        /*
        if(player.isOwner) {
            usersRepository.deleteById(uuid);
        }
        */
        var exist = usersRepository.findById(uuid);
        if (exist.isPresent()) {
            usersRepository.deleteById(uuid);
            return true;
        }
        return false;
    }

    public void notOwner(UUID uuid) {
        usersRepository.notify();
    }

    @Override
    @Transactional
    public boolean updateUser(Users existUser, Users user) {
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());

        addUser(existUser);
        return true;
    }
}
