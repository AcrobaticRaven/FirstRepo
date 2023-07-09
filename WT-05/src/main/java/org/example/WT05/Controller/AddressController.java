package org.example.WT05.Controller;

import org.example.WT05.Model.Address;
import org.example.WT05.Service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    AddService addService;

    @PostMapping("Address")
    public void addAddress(Address address){
        addService.addAddress(address);
    }
}
