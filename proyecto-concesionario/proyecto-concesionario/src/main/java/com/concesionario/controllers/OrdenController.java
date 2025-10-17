package com.concesionario.controllers;

import com.concesionario.dto.OrdenDTO;
import com.concesionario.models.Orden; 
import com.concesionario.services.OrdenService;
import com.concesionario.repositories.OrdenRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final OrdenService ordenService; 
    private final OrdenRepository ordenRepo;

    public OrdenController(OrdenService ordenService, OrdenRepository ordenRepo){
        this.ordenService = ordenService;
        this.ordenRepo = ordenRepo;
    }

    @GetMpapping 
    public List<Orden> listar() {
        return ordenRepo.findAll();
    }

    @GetMapping("/{id}")
    public Orden obtenerPorId(@PathVariable Integer id){
        return ordenRepo.findById(id).orElseThrow(( ) -> new IllegalArgumentException("Orden no encontrada"));
    }

    @PostMapping
    public Orden crearOrden(@Valid @RequestBody OrdenDTO dto){
        return ordenService.crearOrden(dto.ProductoId, dto.Cantidad, dto.Total, dto.Comprador, dto.MetodoPago);
    }




}

