package com.agile.poker.repository;

import com.agile.poker.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    //Users findByUsername(String name);
    Users findByEmail(String email);
}
