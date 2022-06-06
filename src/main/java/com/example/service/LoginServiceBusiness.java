package com.example.service;

import com.example.dto.requests.LoginRequest;
import com.example.dto.responses.LoginResponse;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service

public class LoginServiceBusiness implements LoginService{

    private UserRepository loginRepository;
    private ModelMapper modelMapper;

    public LoginServiceBusiness(UserRepository loginRepository, ModelMapper modelMapper) {
        this.loginRepository = loginRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LoginResponse getOneUserByEmailAndPassword(String email, String password ) {
        // login için repositoy'den o user'ı bul..

        //User user = modelMapper.map(loginRequest, User.class);
        System.out.println("Giris basarılı");

        var result = loginRepository.findUserByEmailAndPassword(email,password);
        return modelMapper.map(result,LoginResponse.class);
        //return loginRepository.findUserByEmailAndPassword(user);

    }
}
