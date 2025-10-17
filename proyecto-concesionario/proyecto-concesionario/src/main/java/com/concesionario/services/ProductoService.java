package com.concesionario.services;

import com.concesionario.repositories.*;
import com.concesionario.models.*;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;




@Service
public class ProductoService {


    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService (ProductoRepository productoRepository, CategoriaRepository categoriaRepository){
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    public List<Producto> listarTodos(){ return productoRepository.findAll(); }

    public Optional<Producto> obtenerPorId(Integer id){
        return productoRepository.findById(id);
    }

    public Producto crearProducto(Producto p){

        if (p.getCategoria() != null && p.getCategoria().getId() != null){
            categoriaRepository.findById(p.getCategoria().getId()).ifPresent(p::setCategoria);

        }
        return productoRepository.save(p);

    }

    public List<Producto> buscarPorMarca(String marca){
        return productoRepository.findByMarcaContainingIgnoreCase(marca);
    }

    @Transactional
    public Producto disminuirStock(Integer productoId, Integer cantidad){
        producto p = productoRepository.findById(productoId).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (p.getStock() >= cantidad) throw new IllegalStateException("No hay suficiente stock");

        p.setStock(p.getStock() - cantidad);
        return p; //se guardara por persistencia

        
    }








}
