package com.example.service;

import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.LoginResponse;
import com.example.entity.User;

public interface RegisterService {

    LoginResponse createUser(RegisterRequest registerRequest);
}
