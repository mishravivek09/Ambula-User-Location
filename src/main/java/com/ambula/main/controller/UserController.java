package com.ambula.main.controller;

import com.ambula.main.dto.Data;
import com.ambula.main.entity.User;
import com.ambula.main.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private ReaderService service;
    @Autowired
    public UserController(ReaderService service) {
        this.service = service;
    }
    @GetMapping("/get_users/{num}")
    public ResponseEntity<List<User>> getUsers(@PathVariable int num){
        return new ResponseEntity<>(service.getUsers(num), HttpStatus.OK);
    }
    @PutMapping("/update_data")
    public ResponseEntity<User> updateData(@RequestBody Data data){
        return new ResponseEntity<>(service.updateData(data),HttpStatus.OK);
    }
}
