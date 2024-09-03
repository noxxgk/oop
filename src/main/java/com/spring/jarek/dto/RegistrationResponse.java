package com.spring.jarek.dto;

import java.time.LocalDateTime;

public class RegistrationResponse {
    public LocalDateTime generationDate;
    public String token;


    public RegistrationResponse() {
    }

    public RegistrationResponse(String token, LocalDateTime generationDate) {
        this.generationDate = generationDate;
        this.token = token;
    }

    public LocalDateTime getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(LocalDateTime generationDate) {
        this.generationDate = generationDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
