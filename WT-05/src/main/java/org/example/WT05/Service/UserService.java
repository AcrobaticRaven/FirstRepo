package org.example.WT05.Service;

import org.example.WT05.Model.User;
import org.example.WT05.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    public void addUser(User user){
        iUserRepo.save(user);
    }

    public String getUser(Integer Id){
        Optional<User>UserOptional = iUserRepo.findById(Id);
        if(UserOptional.isPresent()){
            User user = UserOptional.get();
            return user.toString();
        }return "User not found";
    }
}
