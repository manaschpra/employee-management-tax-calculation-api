package com.example.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotEmpty
    @Column(name = "phone_number")
    private List<String> phoneNumbers;

    @NotNull(message = "Date of joining is mandatory")
    private LocalDate doj;

    @NotNull(message = "Salary is mandatory")
    @Min(value = 1, message = "Salary must be greater than 0")
    private Double salary;


}