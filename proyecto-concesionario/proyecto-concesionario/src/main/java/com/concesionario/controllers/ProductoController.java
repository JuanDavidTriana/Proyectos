package com.concesionario.controllers;

import com.concesionario.model.Producto; 
import com.concesionario.dto.ProductoDTO;
import com.concesionario.repository.CategoriaRepository;
import com.concesionario.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List; 


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService; 
    private final CategoriaRepository categoriaRepo;
    
    public ProductoController(ProductoService productoService, CategoriaRepository categoriaRepo){
        this.productoService = productoService;
        this.categoriaRepo = categoriaRepo;
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Integer id){ .orElseThrow(( ) -> new IllegalArgumentException("Producto no encontrado"));
    }

    @GetMapping("/buscar")
    public List<Producto> buscarPorMarca(@RequestParam String marca){
        return productoService.buscarPorMarca(marca);
    }

    @PostMapping
    public Producto crearProducto(@Valid @RequestBody ProductoDTO dto){

        Producto p = new Producto();
        p.setMarca(dto.Marca);
        p.setModelo(dto.Modelo);
        p.setAnio(dto.Anio);
        p.setPrecio(dto.Precio);
        p.setStock(dto.Stock);
        //set categoria
        categoriaRepo.findById(dto.CategoriaId).ifPresent(p::setCategoria);

        return productoService.crearProducto(p);

    }
        
    @PostMapping("/{id}/comprar")
    public String comprarProducto(@PathVariable Integer id, @RequestParam Integer cantidad, @RequestParam String comprador){
        productoService.disminuirStock(id, cantidad);
        return "Producto comprado" + id + ", cantidad: " + cantidad;
    }




    
}
