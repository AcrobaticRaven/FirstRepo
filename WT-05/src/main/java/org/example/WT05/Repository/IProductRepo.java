package org.example.WT05.Repository;

import org.example.WT05.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends CrudRepository<Product, Integer> {
   // List<Product>findByProductCategory(String category);
}
