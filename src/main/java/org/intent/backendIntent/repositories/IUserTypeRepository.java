package org.intent.backendIntent.repositories;

import org.intent.backendIntent.models.UserTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeRepository extends JpaRepository<UserTypeModel, String> {

    UserTypeModel findTypeById(String id);

}
