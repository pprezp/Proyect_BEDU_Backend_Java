package org.intent.backendIntent.services;

import org.intent.backendIntent.models.UserTypeModel;
import org.intent.backendIntent.repositories.IUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {
    IUserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeService(IUserTypeRepository userTypeRepository){
        this.userTypeRepository = userTypeRepository;
    }

    public UserTypeModel getUserTypeById(String id){
        return userTypeRepository.findTypeById(id);
    }
}
