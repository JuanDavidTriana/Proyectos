package com.concesionario.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;



@Data
@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private String nombre; 


    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos; 

    
}
