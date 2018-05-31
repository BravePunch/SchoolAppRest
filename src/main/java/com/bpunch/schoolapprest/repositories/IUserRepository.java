package com.bpunch.schoolapprest.repositories;

import com.bpunch.schoolapprest.model.entity.User;
import com.bpunch.schoolapprest.model.enums.DataStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    User findByFirstName(String firstName);

    User findByLastName(String lastName);

    User findAllByMetadata_Status(DataStatus dataStatus);

}
