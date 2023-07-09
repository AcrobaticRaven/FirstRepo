package org.example.WT05.Service;

import org.example.WT05.Model.Address;
import org.example.WT05.Repository.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {
    @Autowired
    IAddRepo iAddRepo;

    public void addAddress(Address add){
        iAddRepo.save(add);
    }
}
