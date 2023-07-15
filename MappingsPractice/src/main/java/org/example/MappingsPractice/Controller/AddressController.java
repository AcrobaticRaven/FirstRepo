package org.example.MappingsPractice.Controller;

import org.example.MappingsPractice.Model.Address;
import org.example.MappingsPractice.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("Addresses")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("Address/{Id}")
    public String getAnAddress(@PathVariable Long Id){
        return addressService.getAnAddress(Id);
    }

    @PutMapping("Address")
    public String updateAddress(@RequestParam Long Id, @RequestParam String landmark, @RequestParam String district, @RequestParam String state, @RequestParam String country){
        return addressService.updateAddress(Id,landmark,district,state,country);
    }

    @PostMapping("Address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @DeleteMapping("Address/{Id}")
    public String deleteAddress(@PathVariable Long Id){
        return addressService.removeAddress(Id);
    }
}
