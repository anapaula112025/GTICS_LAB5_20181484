package org.example.gtics_lab5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int technicianId;
    @Column(name = "FirstName", nullable = false)
    @NotBlank
    @Size( max = 300, message = "Los nombres no puede tener más de 300 caracteres")
    @Size( min = 3, message = "Los nombres no puede tener menos de 3 caracteres")
    private String firstName;
    @Column(name = "LastName", nullable = false)
    @NotBlank
    @Size( max = 300, message = "Los nombres no puede tener más de 300 caracteres")
    @Size( min = 3, message = "Los nombres no puede tener menos de 3 caracteres")
    private String lastName;
    @Column(name = "Dni", nullable = false)
    @Digits(integer = 8, fraction = 0, message = "El DNI debe tener exactamente 8 dígitos")
    private String dni;
    @Column(name = "Phone", nullable = false)
    @Digits(integer = 9, fraction = 0, message = "El telefono debe tener exactamente 9 dígitos")
    private String phone;
    @Column(name = "Age", nullable = false)
    @Digits(integer = 4, fraction = 0)
    @Positive(message = "La edad debe ser un número positivo")
    private int age;

}
