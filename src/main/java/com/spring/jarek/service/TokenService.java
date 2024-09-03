package com.spring.jarek.service;

import com.spring.jarek.dto.TokenDataResponse;
import com.spring.jarek.entity.UserData;
import com.spring.jarek.mapper.DataMapper;
import com.spring.jarek.repository.UserDataRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TokenService {

    public TokenService(UserDataRepository tokenDataRepository) {
        this.tokenDataRepository = tokenDataRepository;
    }

    public UserDataRepository tokenDataRepository;

    private final static LocalDateTime serverStartedTimestamp = LocalDateTime.now();


    public String generateToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public List<TokenDataResponse> getTokensList() {
        List<UserData> allTokens = tokenDataRepository.findAll();
        return allTokens.stream()
                .map(userData -> DataMapper.userDataToTokenDataResponse(userData))
                .filter(registrationResponse ->
                        registrationResponse.getGenerationDate().isAfter(serverStartedTimestamp))
                .toList();
    }


    @Scheduled(cron = "0/10 * * ? * *")
    public void checkTokenValidity() {
        tokenDataRepository.findAll().forEach(userData -> {
            if(doesTokenNeedToBeDeactivated(userData)){
                userData.setActive(false);
                tokenDataRepository.save(userData);
                System.out.println("Token " + userData.getToken() + " has been deactivated");
            }
        });
    }

    private boolean doesTokenNeedToBeDeactivated(UserData userData) {
        return userData.getGenerationDate().plusMinutes(1).isBefore(LocalDateTime.now()) && userData.isActive();
    }
}
