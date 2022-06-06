package com.example.service;

import com.example.dto.requests.LoginRequest;
import com.example.dto.responses.LoginResponse;
import com.example.entity.User;

public interface LoginService {
   // User getOneUserByEmailAndPassword(String userEmail, String userPassword);

    LoginResponse getOneUserByEmailAndPassword(String email, String password);
}
