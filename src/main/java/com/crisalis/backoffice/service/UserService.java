package com.crisalis.backoffice.service;

import com.crisalis.backoffice.exception.custom.EmptyElementException;
import com.crisalis.backoffice.exception.custom.NotCreatedException;
import com.crisalis.backoffice.exception.custom.UnauthorizedException;
import com.crisalis.backoffice.model.User;
import com.crisalis.backoffice.model.dto.UserDTO;
import com.crisalis.backoffice.repository.UserRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User saveUser(UserDTO userDTO){
        if(checkUserDTO(userDTO,Boolean.FALSE)){

            return this.userRepo.save(new User(userDTO));
            /*
            // otra forma de hacerlo.
            User.builder()
                    .name(userDTO.getName())
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .build();
            */
        }
        throw new NotCreatedException("Error in save new user");
    }

    public UserDTO loginUser(String username, String password){
        if(checkUserDTO(UserDTO
                .builder()
                .username(username)
                .password(password)
                .build(), Boolean.TRUE)){

            return this.userRepo.findByUsernameAndPassword(username,password).orElseThrow(
                    () -> new UnauthorizedException("Credential invalid")
            ).toUserDTO();
        }
        throw new UnauthorizedException("Credential invalid");
    }
    public List<UserDTO> getListAllUserInDB() {
        return this.userRepo
                .findAll()
                .stream()
                .map(User::toUserDTO)
                .collect(Collectors.toList());
    }

    private Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin){
        if(!isForLogin){
            if(StringUtils.isEmpty(userDTO.getName())) throw new EmptyElementException("Name is empty");
            if(userDTO.getRol() == null) throw new EmptyElementException("Rol is empty");
        }
        if(StringUtils.isEmpty(userDTO.getUsername())){
            throw new EmptyElementException("Username is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())){
            throw new EmptyElementException("Password is empty");
        }
        return Boolean.TRUE;
    }



}
