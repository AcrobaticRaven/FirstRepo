package org.example.UserManagementSystem;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull(message = "Id cannot be null")
    private Integer userId;
    @NotBlank(message = "name cannot be blank")
    private String name;
    @Email(message = "incorrect mail format")
    private String mail;
    private LocalDate DateOfBirth;
    private LocalDate Date;
    private LocalTime time;

}
