package com.concesionario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.concesionario.models.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {


    
}

    