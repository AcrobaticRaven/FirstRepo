package org.example.urlHitCounter.Controller;

import org.example.urlHitCounter.Service.urlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class urlHitController {
  @Autowired
    urlHitService urlhitservice;


    @GetMapping("counter")
  public Integer getcounter(){
     return urlhitservice.getcounter();
  }


    @GetMapping("username/{username}/count")
  public String getUserCount(@PathVariable String username){
    return urlhitservice.getusercounts(username);
  }

}
