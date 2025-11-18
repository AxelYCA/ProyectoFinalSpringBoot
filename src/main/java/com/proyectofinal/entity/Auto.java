package com.proyectofinal.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "autos")
public class Auto {
    
    @Id
    @Column(name = "no_serie", length = 20, nullable = false)
    private String noSerie;
    
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;
    
    @Column(name = "modelo", nullable = false)
    private Integer modelo;
    
    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    public Auto() {}
    
    public Auto(String noSerie, String tipo, Integer modelo, BigDecimal precio, Marca marca) {
        this.noSerie = noSerie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
        this.marca = marca;
    }
    
    public String getNoSerie() { return noSerie; }
    public void setNoSerie(String noSerie) { this.noSerie = noSerie; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public Integer getModelo() { return modelo; }
    public void setModelo(Integer modelo) { this.modelo = modelo; }
    
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}