package com.example.service;

import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.LoginResponse;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceBusiness implements RegisterService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public RegisterServiceBusiness(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // id li user ın olup olmadını kontrol et.
    @Override
    public LoginResponse createUser(RegisterRequest registerRequest) {

        System.out.println(registerRequest);
        User user = modelMapper.map(registerRequest, User.class);
        System.out.println(user);
        var register =  userRepository.save(user);
        System.out.println("qwragdahjsjsjrshshs");
        return modelMapper.map(register, LoginResponse.class);

    }

    /*
    public LoginResponse createUser(RegisterRequest registerRequest) {
    / System.out.println(registerRequest);
        User user = new User();
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setUserRole(registerRequest.getRole());
        System.out.println(user);
        var register =  userRepository.save(user);
        System.out.println("qwragdahjsjsjrshshs");
        return register;

     */
}
