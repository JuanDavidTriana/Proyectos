package com.concesionario.dto;

import jakarta.validation.constraints.*;

public class OrdenDTO {

    @NotNull 
    public Integer cantidad;
    
    @DecimalMin("0.0") 
    public double total;

    @NotBlank 
    public String comprador;

    @NotBlank
    public String metodoPago;

}