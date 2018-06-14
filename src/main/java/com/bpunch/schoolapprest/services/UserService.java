package com.bpunch.schoolapprest.services;

import com.bpunch.schoolapprest.model.dto.UserDto;
import com.bpunch.schoolapprest.model.dto.mappers.UserDtoMapper;
import com.bpunch.schoolapprest.model.entity.Metadata;
import com.bpunch.schoolapprest.model.entity.User;
import com.bpunch.schoolapprest.model.enums.DataStatus;
import com.bpunch.schoolapprest.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.BadRequestException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

        data.setMetadata(new Metadata());
        data.getMetadata().setStatus(DataStatus.ACTIVE);

        User createdEntity = userRepository.save(data);

        return dtoMapper.mapToDto(createdEntity);

    }

    public UserDto updateUser(Integer id, UserDto newEntity) {

        Optional<User> target = userRepository.findById(id);

        if (!target.isPresent())
            throw new BadRequestException("Aucun User trouvé pour l'id: " + id);

        User currentEntity = target.get();

        currentEntity.setFirstName(newEntity.getFirstName());
        currentEntity.setLastName(newEntity.getLastName());
        currentEntity.setEmail(newEntity.getEmail());

        return dtoMapper.mapToDto(userRepository.save(currentEntity));
    }

}
