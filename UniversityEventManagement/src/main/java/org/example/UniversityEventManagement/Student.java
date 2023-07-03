package org.example.UniversityEventManagement;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer StudentID;
    @Pattern(regexp = "^[A-Z].*$", message = "First letter should be capital")
    private String FirstName;
    private String LastName;
    @Min(value = 18)
    @Max(value = 25)
    private Integer Age;
    @Enumerated(EnumType.STRING)
    private TYPE Department;
}
