package com.spring.jarek.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PixelRequest {
    private String token;
    private int x;
    private int y;
    private String color;

    public String getToken() {
        return token;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
