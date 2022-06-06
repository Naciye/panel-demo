package com.example.config;

import com.example.dto.requests.LoginRequest;
import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.LoginResponse;
import com.example.entity.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapperConfig {
    private static final Converter<User, LoginResponse>

    USER_LOGIN_RESPONSE_CONVERTER =
            (context) -> {
                    var user = context.getSource();
                    var response = new LoginResponse();
                    response.setFullName(user.getFullName());
                    response.setEmail(user.getEmail());
                    return response;
            };

    private static final Converter<LoginRequest, User>
    LOGIN_REQUEST_USER_CONVERTER =

            (context) -> {
                var request = context.getSource();
                var user = new User();
                user.setEmail(request.getEmail());
                user.setPassword(request.getPassword());
                return user;
            };
    private static final Converter<RegisterRequest, User>
    REGISTER_REQUEST_USER_CONVERTER =
            (context) -> {
                var request = context.getSource();
                var registerUser = new User();
                registerUser.setFullName(request.getFullName());
                registerUser.setEmail(request.getEmail());
                registerUser.setPassword(request.getPassword());
                registerUser.setUserRole(request.getRole());
                return registerUser;
            };


    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        // olusan instance icin eslestirme stratejisi
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       modelMapper.addConverter(USER_LOGIN_RESPONSE_CONVERTER, User.class, LoginResponse.class);
       modelMapper.addConverter(LOGIN_REQUEST_USER_CONVERTER, LoginRequest.class, User.class);
       modelMapper.addConverter(REGISTER_REQUEST_USER_CONVERTER, RegisterRequest.class, User.class);

        return modelMapper;

    }
}
