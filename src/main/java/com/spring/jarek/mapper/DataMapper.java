package com.spring.jarek.mapper;

import com.spring.jarek.dto.RegistrationResponse;
import com.spring.jarek.dto.TokenDataResponse;
import com.spring.jarek.entity.UserData;

public class DataMapper {
    /*
    This class could be replaced by external library like mapstruct or object mapper
     */
    public static RegistrationResponse userDataRegistrationResponse(UserData userData) {
       return new RegistrationResponse(
                userData.getToken(),
                userData.getGenerationDate());
    }

    public static TokenDataResponse userDataToTokenDataResponse(UserData userData) {
        TokenDataResponse tokenDataResponse = new TokenDataResponse();
        tokenDataResponse.setToken(userData.getToken());
        tokenDataResponse.setGenerationDate(userData.getGenerationDate());
        tokenDataResponse.setActive(userData.isActive());
        return tokenDataResponse;
    }
}
