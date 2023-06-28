package org.example.UserManagementSystem;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    userServices userservices;
@GetMapping("Users")
    public List<User> getallUser(){
        return userservices.getallUser();
    }
@DeleteMapping("user/{UserId}")
    public String deleteUser(@PathVariable Integer UserId){
   return userservices.deleteUser(UserId);
    }
@PostMapping("user")
    public String addUser(@RequestBody  @Valid User user) {
    return userservices.addUser(user);
}

@GetMapping("user/{userId}")
    public String getUser(@PathVariable Integer userId){
    return userservices.getUser(userId);
    }
@PutMapping("user")
    public String updateUserinfo(@RequestParam @Valid Integer userid, @RequestParam @Valid String name, @RequestParam @Valid String mail, @RequestParam  LocalDate dob,@RequestParam LocalDate date, @RequestParam LocalTime time){
    return userservices.updateUserinfo(userid, name, mail, dob, date, time);
    }
}
