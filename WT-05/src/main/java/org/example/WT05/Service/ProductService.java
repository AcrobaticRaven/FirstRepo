package org.example.WT05.Service;

import org.example.WT05.Model.Product;
import org.example.WT05.Repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class
ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public void addProduct(Product product){
        iProductRepo.save(product);
    }

//    public List<Product> getProducts(String category){
//        return iProductRepo.findByProductCategory(category);
//    }

//    public List<Product> getAllProducts(){
//
//        List<Product>list = new ArrayList<>();
//        list.addAll(iProductRepo);
//        return list;
//    }

    public String deleteProducts(Integer Id){
        Optional<Product>ProductOptional = iProductRepo.findById(Id);
        if(ProductOptional.isPresent()){
            Product product = ProductOptional.get();
            iProductRepo.delete(product);
            return "Product has been removed";
        }return "Product not found";
    }
}
