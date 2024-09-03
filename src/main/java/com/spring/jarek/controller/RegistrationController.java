package com.spring.jarek.controller;

import com.spring.jarek.dto.PixelRequest;
import com.spring.jarek.dto.RegistrationResponse;
import com.spring.jarek.dto.TokenDataResponse;
import com.spring.jarek.mapper.DataMapper;
import com.spring.jarek.service.ImageService;
import com.spring.jarek.service.RegistrationService;
import com.spring.jarek.service.TokenService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService; // wersja automagiczna
    private final TokenService tokenService; // wersja automagiczna

    private final ImageService imageService;


    public RegistrationController(RegistrationService registrationService, TokenService tokenService, ImageService imageService) {
        this.registrationService = registrationService;
        this.tokenService = tokenService;
        this.imageService = imageService;
    }

    @PostMapping("register")
    public ResponseEntity<RegistrationResponse> register() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registrationService.register());
    }

    @GetMapping("tokens")
    public ResponseEntity<List<TokenDataResponse>> tokens() {
        return ResponseEntity.ok(tokenService.getTokensList());
    }

    @GetMapping("image")
    public ResponseEntity<Resource> getImage() throws MalformedURLException {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageService.getImage());
    }

    @PostMapping("pixel")
    public void pixel(@RequestBody PixelRequest request) throws IOException {
        System.out.println("In pixel");
        imageService.setPixel(request);
    }
}
