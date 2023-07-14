package com.ambula.main.service;

import com.ambula.main.entity.User;

import java.util.List;

public interface AdminService {
    public User registerAdmin(User user);
    public User registerUser(User user,long adminId);
    public User updateUser(User user,long adminId);
    public User deleteUser(long userId,long adminId);
    public List<User> getAllUsers(long adminId);
}
