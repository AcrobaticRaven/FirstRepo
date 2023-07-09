package org.example.WT05.Controller;

import org.example.WT05.Model.Product;
import org.example.WT05.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("Product")
    public void addProduct(Product product){
        productService.addProduct(product);
    }

//    @GetMapping("Products")
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//    }

//    @GetMapping("Product/category")
//    public List<Product> getProduct(String category){
//        return productService.getProducts(category);
//    }

    @DeleteMapping("Product")
    public String deleteProduct(Integer Id){
        return productService.deleteProducts(Id);
    }
}
