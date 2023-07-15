package org.example.MappingsPractice.Service;

import org.example.MappingsPractice.Model.Laptop;
import org.example.MappingsPractice.Repository.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo laptopRepo;


    public List<Laptop> getAllLaptops(){
        return laptopRepo.findAll();
    }

    public String addLaptop(Laptop laptop){
        laptopRepo.save(laptop);
        return "laptop has been added";
    }

    public String updateLaptop(Long Id,String laptopName, String laptopBrand, String laptopPrice){
        Optional<Laptop> laptopOptional = laptopRepo.findById(Id);
        if(laptopOptional.isPresent()){
            Laptop laptop = laptopOptional.get();
            laptop.setLaptopBrand(laptopBrand);
            laptop.setLaptopName(laptopName);
            laptop.setLaptopPrice(laptopPrice);
            laptopRepo.save(laptop);
            return "Laptop has been updated";
        }return "Laptop could not be found for Id : " + Id;
    }

    public String deleteLaptop(Long Id){
        Optional<Laptop>laptopoptional = laptopRepo.findById(Id);
        if(laptopoptional.isPresent()){
            Laptop laptop = laptopoptional.get();
            laptopRepo.delete(laptop);
            return "laptop has been removed ";
        }return "could not find a laptop of Id : " + Id;
    }
}
