package com.ambula.main.controller;

import com.ambula.main.entity.User;
import com.ambula.main.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService service;
    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }
    @PostMapping("/create_data")
    public ResponseEntity<User> registerUser(@RequestBody User user, @RequestParam long adminId){
        return new ResponseEntity<>(service.registerUser(user,adminId), HttpStatus.CREATED);
    }
    @PostMapping("/create_admin")
    public ResponseEntity<User> registerAdmin(@RequestBody User user){
        return new ResponseEntity<>(service.registerAdmin(user), HttpStatus.CREATED);
    }
    @PutMapping("/update_user")
    public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam long adminId){
        return new ResponseEntity<>(service.updateUser(user,adminId), HttpStatus.OK);
    }
    @DeleteMapping("/delete_user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId, @RequestParam long adminId){
        return new ResponseEntity<>(service.deleteUser(userId,adminId), HttpStatus.OK);
    }
    @GetMapping("/all/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam long adminId){
        return new ResponseEntity<>(service.getAllUsers(adminId),HttpStatus.OK);
    }
}
