package com.example.controller;

import com.example.dto.requests.LoginRequest;
import com.example.dto.requests.RegisterRequest;
import com.example.dto.responses.LoginResponse;
import com.example.service.LoginService;
import com.example.service.RegisterService;
import com.sun.tools.jconsole.JConsoleContext;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;

@RestController
@RequestScope // request gelin ve comp. başlatırken
@RequestMapping("/login")
public class UserController {

    private final LoginService loginService;
    private final RegisterService registerService;
    private final ModelMapper modelMapper;

    public UserController(LoginService loginService, ModelMapper modelMapper, RegisterService registerService) {
        this.loginService = loginService;
        this.modelMapper = modelMapper;
        this.registerService = registerService;
    }

    /*
    * GetMapping de requestBody kullanma-
    * RequestParam ile type ı ve değişkeni ver.
    * ex: @RequestParam String email
     */
    @GetMapping  //
    public LoginResponse getUser(@RequestParam String email, @RequestParam String password) {
        return loginService.getOneUserByEmailAndPassword(email, password);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse createUser(@RequestBody RegisterRequest registerRequest){
        System.out.println("controller: "+registerRequest);
        Objects.nonNull(registerRequest);
        return registerService.createUser(registerRequest);
    }


/*
    @PostMapping
    public void test(){
        User user= new User();
        user.setEmail("555@");
        loginRepository.save(user);
        System.out.println("helloooo");
    }

 */

}