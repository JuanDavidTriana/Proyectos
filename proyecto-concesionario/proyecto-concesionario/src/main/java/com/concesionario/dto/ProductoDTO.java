package com.concesionario.dto;

import jakarta.validation.constrains.*;

public class ProductoDTO {

    @NotBlank
    public String marca; 
    @NotBlank 
    public String modelo; 
    @Min(1900) public Integer anio; 
    @DecimalMin("0.0") public double precio;
    @NotNull public Long categoriaId;

    
}
