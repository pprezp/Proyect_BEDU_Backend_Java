package org.intent.backendIntent.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.intent.backendIntent.models.UserModel;
import org.intent.backendIntent.models.UserTypeModel;
import org.intent.backendIntent.repositories.IUserRepository;
import org.intent.backendIntent.repositories.IUserTypeRepository;
import org.intent.backendIntent.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
@Validated
public class UserController {

    UserService userService;
    private final IUserRepository iUserRepository;
    private final IUserTypeRepository iUserTypeRepository;

    public UserController(UserService userService,
                          IUserRepository iUserRepository,
                          IUserTypeRepository iUserTypeRepository) {
        this.userService = userService;
        this.iUserRepository = iUserRepository;
        this.iUserTypeRepository = iUserTypeRepository;
    }

    @GetMapping("/users")
    public ResponseEntity <List<UserModel>> getUsers(
            @Email @RequestParam(required = false) String email,
            @RequestParam(required = false) String username
    ){
        try{
            List<UserModel> data = new ArrayList<UserModel>();
            if (email != null) {
//                data = userService.getUsersByEmailAndPassword(email);
            }else if (username != null) {
                data = userService.getUsersByUsername(username);
            }
            if(data.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(data, HttpStatus.OK);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUserById(@Valid @PathVariable String id){
        try{
            UserModel user = new UserModel();
            user = userService.getUserById(id);
            if ( user != null ){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user, String userTypeId){
        try{
            UserTypeModel userType = iUserTypeRepository.findTypeById(userTypeId);
            UserModel saved = new UserModel();

            user.setUserType(userType);
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            saved = userService.createUser(user);

            return new ResponseEntity<>(saved, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/authenticate")
    public ResponseEntity<?> login( @RequestParam String email, String password ){
        try{
            UserModel user = userService.getUsersByEmailAndPassword(email, password);
            System.out.println("DATA");
            System.out.println(user.getEmail());
        }catch(Exception e){

        }

        return null;
    }
}
