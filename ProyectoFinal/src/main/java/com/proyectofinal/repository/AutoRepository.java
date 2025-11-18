package com.proyectofinal.repository;

import com.proyectofinal.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, String> {
    
    @Query("SELECT a FROM Auto a JOIN FETCH a.marca m WHERE LOWER(m.nombre) = LOWER(:nombreMarca)")
    List<Auto> findByMarcaNombre(@Param("nombreMarca") String nombreMarca);
    
    @Query("SELECT a FROM Auto a JOIN FETCH a.marca WHERE a.precio > :precioMinimo")
    List<Auto> findByPrecioGreaterThan(@Param("precioMinimo") Double precioMinimo);
    
    @Query("SELECT a FROM Auto a JOIN FETCH a.marca")
    List<Auto> findAllWithMarca();
}