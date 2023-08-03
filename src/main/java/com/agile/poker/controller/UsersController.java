package com.agile.poker.controller;

import com.agile.poker.entity.Users;
import com.agile.poker.request.SigninRequest;
import com.agile.poker.request.SignupRequest;
import com.agile.poker.response.ApiResponse;
import com.agile.poker.response.JWTAuthResponse;
import com.agile.poker.security.AuthService;
import com.agile.poker.service.EncryptPass;
import com.agile.poker.service.impl.PlayersServiceImpl;
import com.agile.poker.service.UsersService;
import com.agile.poker.utils.Endpoints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Endpoints.USERS)
@RequiredArgsConstructor
@Slf4j
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private EncryptPass encryptPass;
    @Autowired
    private PlayersServiceImpl playersService;

    @GetMapping(Endpoints.GET_USERS)
    public ResponseEntity<List<Users>> getAllUsers() {
        //que no muestre la contraseña
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Users> getUsersById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }

    @PostMapping(Endpoints.SAVE)
    public ResponseEntity<Users> addUser(@RequestBody Users users) {

        var userEncypted = encryptPass.encryptPassword(users);
        var userToSave = usersService.addUser(userEncypted);
        //String token = getJWTToken(user.getName());

        if (userToSave) {
            log.info("Usuario creado correctamente");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            log.info("El usuario no se ha podido registrar. Revisar si los datos introducidos son correctos");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(Endpoints.EDIT)
    public ResponseEntity<Users> updateUser(@PathVariable("id") UUID id, @RequestBody Users users) {
        var existUser = usersService.findById(id);

        if (!existUser.toString().isEmpty()) {
            usersService.updateUser(existUser, users);
            log.info("Usuario modificado correctamente");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            log.info("El usuario no se ha podido modificar");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") UUID id) {

        var existAndDelete = usersService.deleteUser(id);

        if (existAndDelete) {
            log.info("Usuario eliminado correctamente");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("El usuario no se ha podido eliminar. Compruebe si tiene los permisos necesarios para realizar la operación o si el usuario existe.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}