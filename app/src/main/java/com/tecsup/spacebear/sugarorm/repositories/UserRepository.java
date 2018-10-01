package com.tecsup.spacebear.sugarorm.repositories;

import com.orm.SugarRecord;
import com.tecsup.spacebear.sugarorm.models.User;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static void create(String fullname,String email,String password){
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        //insert into user ;
        SugarRecord.save(user);
    }
}
