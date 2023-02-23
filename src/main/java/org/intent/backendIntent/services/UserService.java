package org.intent.backendIntent.services;

import org.intent.backendIntent.models.UserModel;
import org.intent.backendIntent.models.UserTypeModel;
import org.intent.backendIntent.repositories.IUserRepository;
import org.intent.backendIntent.repositories.IUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    private final IUserTypeRepository iUserTypeRepository;

    @Autowired
    public UserService(IUserRepository userRepository,
                       IUserTypeRepository iUserTypeRepository) {
        this.userRepository = userRepository;
        this.iUserTypeRepository = iUserTypeRepository;
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserById(String id){
        return userRepository.getUserById(id);
    }

    public List<UserModel> getUsersByUsername(String username){
        return userRepository.findByUsernameContains(username);
    }

    public UserModel getUsersByEmailAndPassword(String email, String password){
        UserTypeModel userTypeb = new UserTypeModel();
        userTypeb = iUserTypeRepository.findTypeById("2");
        UserModel user =  userRepository.findByEmailContainsAndUserTypeAndActive(email, userTypeb, true);

        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(password);

        if(BCrypt.checkpw(password, user.getPassword())){
            System.out.println(user.getId());
            return user;
        }
        return null;
    }

    public UserModel createUser(UserModel user){
        UserTypeModel usertype = iUserTypeRepository.findTypeById("2");
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setUserType(usertype);
        return userRepository.save(user);
    }
}
