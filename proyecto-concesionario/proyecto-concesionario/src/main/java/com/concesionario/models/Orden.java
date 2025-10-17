package com.concesionario.models; 

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Orden{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private Integer cantidad; 
    private Integer productoId;
    private double total; 
    private String comprador;
    private String metodoPago; 
    private LocalDateTime fecha = LocalDateTime.now();



}