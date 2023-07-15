package org.example.MappingsPractice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "laptop")
@Entity

public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId;
    private String laptopName;
    private String laptopBrand;
    private String laptopPrice;

    @OneToOne
    @JoinColumn(name = "fk_student_id")
    Student student;
}
