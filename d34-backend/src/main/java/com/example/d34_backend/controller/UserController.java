package com.example.d34_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.d34_backend.model.User;
import com.example.d34_backend.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepo repo;

    // get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    // create employees rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return repo.save(user);
    }

    // get by id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = repo.findById(id).orElseThrow();
        return ResponseEntity.ok(user);
    }

    // update user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user = repo.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());

        User updatedUser = repo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        User user = repo.findById(id).orElseThrow();
        repo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
