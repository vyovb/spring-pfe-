package com.network.com.dto;


import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String password;
    private String email;
}
