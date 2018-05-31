package com.bpunch.schoolapprest.services;

import com.bpunch.schoolapprest.model.dto.UserDto;
import com.bpunch.schoolapprest.model.dto.mappers.UserDtoMapper;
import com.bpunch.schoolapprest.model.entity.User;
import com.bpunch.schoolapprest.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService{

    private final IUserRepository userRepository;

    private UserDtoMapper dtoMapper = new UserDtoMapper();

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<UserDto> getAllUsers() {

        Iterator<User> results = userRepository.findAll().iterator();

        List<UserDto> returnData = new ArrayList<>();

        while (results.hasNext()) {

            returnData.add(dtoMapper.mapToDto(results.next()));

        }

        return returnData;
    }

    public UserDto createUser(UserDto newEntity) {

        User data = dtoMapper.mapToEntity(newEntity);

        User createdEntity = userRepository.save(data);

        return dtoMapper.mapToDto(createdEntity);

    }

}
