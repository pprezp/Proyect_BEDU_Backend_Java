package org.intent.backendIntent.repositories;

import org.intent.backendIntent.models.UserModel;
import org.intent.backendIntent.models.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<UserModel, String> {
    UserModel getUserById(String id);
    List<UserModel> findByUsernameContains(String username);
    List<UserModel> findByEmailContains(String email);
    UserModel findByEmailContainsAndUserTypeAndActive(String email, UserTypeModel userType, Boolean boolvar);
    UserModel findByEmailAndPasswordAndUserTypeAndActive(String email, String password, UserTypeModel userType, Boolean boolvar);

    Optional<UserModel> findByEmailAndPassword(String email, String password);
}
