package org.intent.backendIntent.services;

import org.intent.backendIntent.models.UserModel;
import org.intent.backendIntent.models.UserTypeModel;
import org.intent.backendIntent.repositories.IUserRepository;
import org.intent.backendIntent.repositories.IUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    IUserRepository userRepository;
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

    public List<UserModel> getUsersByEmail(String email){
        UserTypeModel userTypeb = new UserTypeModel();
        userTypeb = iUserTypeRepository.findTypeById("1");
        return userRepository.findByEmailContainsAndUserTypeAndActive(email, userTypeb, true);
    }
}
