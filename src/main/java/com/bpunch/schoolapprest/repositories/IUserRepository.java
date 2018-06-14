package com.bpunch.schoolapprest.repositories;

import com.bpunch.schoolapprest.model.entity.User;
import com.bpunch.schoolapprest.model.enums.DataStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {

    User findUserByFirstName(String firstName);

    User findUserByLastName(String lastName);

    User findUserByEmail(String email);

    User findAllByMetadata_Status(DataStatus dataStatus);

}
