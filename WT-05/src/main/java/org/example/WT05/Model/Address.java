package org.example.WT05.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String landmark;
    private String phonenumber;
    private String zipcode;
    private String state;

    @OneToOne
    @JoinColumn(name = "fk_userId")
    User user;
}
