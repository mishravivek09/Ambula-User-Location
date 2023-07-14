package com.ambula.main.service;

import com.ambula.main.dto.Data;
import com.ambula.main.entity.User;

import java.util.List;

public interface ReaderService {
    public List<User> getUsers(int num);
    public User updateData(Data data);
}
