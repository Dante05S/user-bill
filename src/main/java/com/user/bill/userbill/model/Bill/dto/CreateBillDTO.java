package com.user.bill.userbill.model.Bill.dto;

import java.io.Serializable;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CreateBillDTO implements Serializable {
    @NotNull(message = "El monto total es obligatorio")
    @DecimalMin(value = "5000.0", message = "El monto total debe ser mayor a 5000")
    private double totalAmount;

    @NotNull(message = "La descripción es obligatoria")
    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El id del usuario es obligatorio")
    private Long userId;
}
