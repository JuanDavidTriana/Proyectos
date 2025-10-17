package com.concesionario.controllers;

import com.concesionario.models.Categoria; 
import com.concesionario.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepo;

    public CategoriaController(CategoriaRepository categoriaRepo){
        this.categoriaRepo = categoriaRepo;
    }

    @GetMapping
    public List<Categoria> listarTodas(){
        return categoriaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Integer id){
        return categoriaRepo.findById(id).orElseThrow(( ) -> new IllegalArgumentException("Categoria no encontrada"));
    }

    @PostMapping
    public Categoria crearCategoria(@Valid @RequestBody Categoria c){
        return categoriaRepo.save(c);
    }

}