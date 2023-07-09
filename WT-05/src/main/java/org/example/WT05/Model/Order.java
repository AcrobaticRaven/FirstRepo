package org.example.WT05.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @OneToOne
    @JoinColumn(name = "fk_product_Id")
    Product product;
    @OneToOne
    @JoinColumn(name = "fk_user_Id")
    User user;
    @OneToOne
    @JoinColumn(name = "fk_add_Id")
    Address address;

}

