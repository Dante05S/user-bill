package com.user.bill.userbill.model.User.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CreateUserDTO implements Serializable {
    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "Debe ser mayor de edad")
    private int age;

    @NotNull(message = "El email es obligatorio")
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser valido")
    private String email;
}
