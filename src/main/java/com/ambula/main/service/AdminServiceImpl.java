package com.ambula.main.service;

import com.ambula.main.entity.User;
import com.ambula.main.enums.Role;
import com.ambula.main.exception.MyRuntimeException;
import com.ambula.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    private UserRepository repository;
    @Autowired
    public AdminServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerAdmin(User user) {
        if(!user.getRole().equals(Role.ADMIN)){
            throw new MyRuntimeException("Invalid role, Please enter correct spelling : "+Role.ADMIN);
        }
        return repository.save(user);
    }

    @Override
    public User registerUser(User user, long adminId) {
        Optional<User> opt=repository.findById(adminId);
        if(!opt.isPresent()){
            throw new MyRuntimeException("Invalid admin id");
        }
        User usr=opt.get();
        if(usr.getRole().equals(Role.READER)){
            throw new MyRuntimeException("Invalid admin role");
        }
        if(!user.getRole().equals(Role.READER)){
            throw new MyRuntimeException("Role should be : "+Role.READER);
        }
        return repository.save(user);
    }

    @Override
    public User updateUser(User user, long adminId) {
        Optional<User> opt=repository.findById(adminId);
        if(!opt.isPresent()){
            throw new MyRuntimeException("Invalid admin id");
        }
        User usr=opt.get();
        if(usr.getRole().equals(Role.READER)){
            throw new MyRuntimeException("Invalid admin role");
        }
        Optional<User> optional=repository.findById(user.getId());
        if(!optional.isPresent()){
            throw new MyRuntimeException("User not found with id : "+user.getId());
        }
        return repository.save(user);
    }

    @Override
    public User deleteUser(long userId, long adminId) {
        Optional<User> opt=repository.findById(adminId);
        if(!opt.isPresent()){
            throw new MyRuntimeException("Invalid admin id");
        }
        User usr=opt.get();
        if(usr.getRole().equals(Role.READER)){
            throw new MyRuntimeException("Invalid admin role");
        }
        Optional<User> optional=repository.findById(userId);
        if(!optional.isPresent()){
            throw new MyRuntimeException("User not found with id : "+userId);
        }
        User user=opt.get();
        repository.delete(user);
        return user;
    }

    @Override
    public List<User> getAllUsers(long adminId) {
        Optional<User> opt=repository.findById(adminId);
        if(!opt.isPresent()){
            throw new MyRuntimeException("Invalid admin id");
        }
        User usr=opt.get();
        if(usr.getRole().equals(Role.READER)){
            throw new MyRuntimeException("Invalid admin role");
        }
        List<User> list=repository.findAll();
        if(list.isEmpty()){
            throw new MyRuntimeException("User list is empty");
        }
        return list;
    }
}
