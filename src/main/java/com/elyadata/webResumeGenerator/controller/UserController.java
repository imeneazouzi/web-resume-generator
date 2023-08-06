package com.elyadata.webResumeGenerator.controller;


import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.dto.UserDTO;
import com.elyadata.webResumeGenerator.services.ResumeService;
import com.elyadata.webResumeGenerator.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("/user-email/{email}")
    public ResponseEntity<List<UserDTO>> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }
    @PostMapping("/")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }
}
