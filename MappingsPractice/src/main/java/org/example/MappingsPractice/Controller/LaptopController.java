package org.example.MappingsPractice.Controller;

import org.example.MappingsPractice.Model.Laptop;
import org.example.MappingsPractice.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    LaptopService laptopService;



    @GetMapping("Laptops")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }


    @PutMapping("laptop")
    public String updateLaptop(@RequestParam Long Id, @RequestParam String name, @RequestParam String brand, @RequestParam String price){
        return laptopService.updateLaptop(Id,name,brand,price);
    }

    @PostMapping("laptop")
    public String addLaptop(@RequestBody Laptop laptop){
        return laptopService.addLaptop(laptop);
    }

    @DeleteMapping("laptop/{Id}")
    public String deleteLaptop(@PathVariable Long Id){
        return laptopService.deleteLaptop(Id);
    }
}
