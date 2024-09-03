package com.spring.jarek.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TokenDataResponse {

    public String token;
    public LocalDateTime generationDate;

    public boolean active;

    public TokenDataResponse() {
    }

    public TokenDataResponse(String token, LocalDateTime generationDate, boolean active) {
        this.token = token;
        this.generationDate = generationDate;
        this.active = active;
    }
}
