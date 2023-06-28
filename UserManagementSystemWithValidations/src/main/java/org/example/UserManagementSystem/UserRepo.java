package org.example.UserManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepo {
    @Autowired
    List<User> userList;


    public List<User> getallUser(){
        return userList;
    }
    public void deleteUser(User user){
        userList.remove(user);
    }
    public void addUser(User user) {
        userList.add(user);
    }

}
