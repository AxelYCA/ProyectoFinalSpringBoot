package com.proyectofinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;

    public Marca() {}
    
    public Marca(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    public Long getIdMarca() { return idMarca; }
    public void setIdMarca(Long idMarca) { this.idMarca = idMarca; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}