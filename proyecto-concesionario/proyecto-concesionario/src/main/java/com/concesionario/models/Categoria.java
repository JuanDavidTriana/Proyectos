package com.concesionario.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    private String nombre; 


    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference
    private List<Producto> productos; 

    // Constructores
    public Categoria() {}

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
}
