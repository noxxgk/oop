package com.spring.jarek.service;

import com.spring.jarek.dto.RegistrationResponse;
import com.spring.jarek.entity.UserData;
import com.spring.jarek.mapper.DataMapper;
import com.spring.jarek.repository.UserDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    private final TokenService tokenService;

    private final UserDataRepository userDataRepository;

    public RegistrationService(TokenService tokenService, UserDataRepository userDataRepository) {
        this.tokenService = tokenService;
        this.userDataRepository = userDataRepository;
    }

    public RegistrationResponse register(){
        UserData createdUser = createUserData();
        UserData savedUser = userDataRepository.save(createdUser);
        return DataMapper.userDataRegistrationResponse(savedUser);
    }

    private UserData createUserData(){
        UserData createdUserData = new UserData();
        createdUserData.setToken(tokenService.generateToken());
        createdUserData.setGenerationDate(LocalDateTime.now());
        createdUserData.setActive(true);
        return createdUserData;
    }

}
