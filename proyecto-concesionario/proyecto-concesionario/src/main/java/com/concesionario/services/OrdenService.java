package com.concesionario.services;

import com.concesionario.repositories.*;
import com.concesionario.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;
    private final ProductoService productoService;

    public OrdenService(OrdenRepository ordenRepository, ProductoService productoService) {
        this.ordenRepository = ordenRepository;
        this.productoService = productoService;
    }

    @Transactional
    public Orden crearOrden(Integer productoId, Integer cantidad, double total, String comprador, String metodoPago){
        Producto producto = productoService.obtenerPorId(productoId).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (producto.getStock()< cantidad ) throw new IllegalStateException("No hay suficiente stock");
        //ACTUALIZAR EL INVENTARIO
        productoService.disminuirStock(productoId, cantidad);
        // GUARDAR ORDENES
        Orden o = new Orden();
        o.setProductoId(productoId);)
        o.setCantidad(cantidad);
        o.setTotal(producto.getPrecio() * cantidad) ;
        o.setComprador(comprador);
        o.setMetodoPago(metodoPago);

        return ordenRepository.save(o);

    }
    
    


}