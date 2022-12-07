package com.genspringboot.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genspringboot.proyect.model.User;
import com.genspringboot.proyect.service.UserService;

// esto nos permite hacer peticiones desde cualquier parte, no solo desdde nuestro servidor local
@CrossOrigin("*")
@RestController
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User newUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    public User updatUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
