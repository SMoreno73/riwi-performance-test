package com.performance.test.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.performance.test.api.dto.request.UserRequest;
import com.performance.test.api.dto.response.UserResponse;
import com.performance.test.infrastructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name= "User")
@CrossOrigin(origins="*")
public class UserController {

    private final IUserService userService;

    @Operation(
        summary = "Create a new user",
        description = "You must send name and email")
    @PostMapping
    public ResponseEntity<UserResponse> insert(
        @Validated @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(this.userService.create(request));
    }
    
}
