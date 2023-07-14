package com.ambula.main.service;

import com.ambula.main.dto.Data;
import com.ambula.main.entity.User;
import com.ambula.main.enums.Role;
import com.ambula.main.exception.MyRuntimeException;
import com.ambula.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReaderServiceImpl implements ReaderService{
    private UserRepository repository;
    @Autowired
    public ReaderServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers(int num) {
        List<User> list=repository.findAll();
        if(list.isEmpty()){
            throw new MyRuntimeException("User list is empty.");
        }

        Map<User,Double> hm=new HashMap<>();

        List<User> res=new ArrayList<>();

        for(User usr : list){
            //            x2-x1+y2-y1,2

            if(usr.getRole().equals(Role.READER)){
                double distance = Math.sqrt(Math.pow((usr.getLongitude() - 0), 2) + Math.pow((usr.getLatitude() - 0), 2));
                hm.put(usr,distance);
            }
        }
        List<Map.Entry<User,Double>> entryList=new ArrayList<>(hm.entrySet());

        Collections.sort(entryList,Comparator.comparingDouble(Map.Entry::getValue));

        if(num>hm.size()){
            throw new MyRuntimeException("User list size is smaller than : "+num);
        }

        for(int i=0;i<num;i++){
            res.add(entryList.get(i).getKey());
        }

        return res;
    }

    @Override
    public User updateData(Data data) {
        Optional<User> opt=repository.findById(data.getUserId());
        if(!opt.isPresent()){
            throw new MyRuntimeException("Invalid user id !");
        }
        User user=opt.get();
        if(user.getRole().equals(Role.ADMIN)){
            throw new MyRuntimeException("You can't update admin data.");
        }
        user.setLatitude(data.getLatitude());
        user.setLongitude(data.getLongitude());
        return repository.save(user);
    }
}
