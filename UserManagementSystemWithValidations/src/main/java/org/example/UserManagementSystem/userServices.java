package org.example.UserManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Service
public class userServices {


    @Autowired
    UserRepo userrepo;

    public List<User> getallUser(){
        return userrepo.getallUser();
    }
    public String deleteUser(Integer UserId){
        for(User user : userrepo.getallUser()){
            if(user.getUserId().equals(UserId)){
                userrepo.deleteUser(user);
                return "User has been removed";
            }
        }return "Id could not be found";
    }
    public String addUser( User user) {
        userrepo.addUser(user);
        return "User was added";
    }
    public String getUser( Integer userId){
        for(User user : userrepo.getallUser()){
            if(user.getUserId().equals(userId)){
                return ("the Id matches with " + user);
            }
        }return "Id could not be found";
    }
    public String updateUserinfo(Integer userid, String name, String mail, LocalDate dob, LocalDate date, LocalTime time){
        for(User user : userrepo.getallUser()){
            if(user.getUserId().equals(userid)){
                user.setName(name);
                user.setMail(mail);
                user.setDateOfBirth(dob);
                user.setDate(date);
                user.setTime(time);
                return "User info has been updated";
            }
        }return "Id could not be found";
    }
}
