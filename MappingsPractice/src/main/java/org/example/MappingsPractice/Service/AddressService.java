package org.example.MappingsPractice.Service;

import org.example.MappingsPractice.Model.Address;
import org.example.MappingsPractice.Repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getAllAddress(){
        return addressRepo.findAll();
    }
    public String getAnAddress(Long Id){
        Optional<Address>addressOptional= addressRepo.findById(Id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
           return address.toString();
        }return "Address not found";
    }

    public String updateAddress(Long Id, String landmark,String district, String state,String country){
        Optional<Address>addressOptional= addressRepo.findById(Id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            address.setDistrict(district);
            address.setLandmark(landmark);
            address.setState(state);
            address.setCountry(country);
            addressRepo.save(address);
            return "Address updated for Id : " + address.getAddressId();
        }return "Address not found";

    }

    public String addAddress(Address address){
        addressRepo.save(address);
        return "Address has been added";
    }

    public String removeAddress(Long Id){
        Optional<Address>addressOptional= addressRepo.findById(Id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            addressRepo.delete(address);
            return "Address has been removed";
        }   return "Address could not be found of Id : " + Id;
    }
}
