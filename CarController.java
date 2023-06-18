package org.example.WT03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {



    @Autowired
   private Car c;


    @GetMapping("getDetails")
    public  String getDetails(){
        String details = c.toString();
        System.out.println("Starting to send mail");
        MailMetaData.details = details;
       MailHandler mailHandler = new MailHandler();
       mailHandler.sendMail();

        return details;
    }
}

