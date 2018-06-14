package com.bpunch.schoolapprest.repositories;

import com.bpunch.schoolapprest.model.entity.Message;
import com.bpunch.schoolapprest.model.enums.DataStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends CrudRepository<Message, Integer> {

    Message findAllByMetadata_Status(DataStatus dataStatus);

}
