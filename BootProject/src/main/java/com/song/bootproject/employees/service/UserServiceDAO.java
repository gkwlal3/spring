package com.song.bootproject.employees.service;

import com.song.bootproject.employees.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service //bean에 service 등록
public class UserServiceDAO { //DB을 읽거나 수정 -> DAO
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static { //DB 역할 영구적으로 3개의 인스턴스 유지
        users.add(new User(1, "song", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Jang", new Date()));
    }

    public List<User> findAll(){ //interface findAll
        return users;
    }

    public User save(User user){ //interface insert
        if(user.getId() == null)
            user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(Integer id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
