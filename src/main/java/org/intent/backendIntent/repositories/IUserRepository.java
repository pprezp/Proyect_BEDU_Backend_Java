package org.intent.backendIntent.repositories;

import org.intent.backendIntent.models.UserModel;
import org.intent.backendIntent.models.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository  extends JpaRepository<UserModel, String> {
    UserModel getUserById(String id);
    List<UserModel> findByUsernameContains(String username);
    List<UserModel> findByEmailContains(String email);
    List<UserModel> findByEmailContainsAndUserTypeAndActive(String email, UserTypeModel userType, Boolean boolvar);
}
