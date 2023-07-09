package org.example.WT05.Controller;

import org.example.WT05.Model.User;
import org.example.WT05.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("User")
    public void addUser(User user){
        userService.addUser(user);
    }
}
