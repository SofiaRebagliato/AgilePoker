package com.agile.poker.service;

import com.agile.poker.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;


public interface UsersService {

    public List<Users> findAll();

    public Users findById(UUID uuid);
    //public Users findByUsername(String name);
    //public Users findByUserName(Users user);
    public boolean addUser(Users user);
    public boolean deleteUser(UUID uuid);
    public void notOwner(UUID uuid);
    public boolean updateUser(Users existUser, Users user);
    public Users findByEmail(Users user);
    //public Users findByEmail(String name);
    //UserDetailsService userDetailsService();
}
