package com.proyectofinal.controller;

import com.proyectofinal.entity.Auto;
import com.proyectofinal.entity.Marca;
import com.proyectofinal.repository.AutoRepository;
import com.proyectofinal.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AutoController {
    
    @Autowired
    private AutoRepository autoRepository;
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping("/autos/marca/{nombre}")
    public ResponseEntity<List<Auto>> getAutosByMarca(@PathVariable("nombre") String nombre) {
        try {
            List<Auto> autos = autoRepository.findByMarcaNombre(nombre);
            return ResponseEntity.ok(autos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/autos/precio/{precioMin}")
    public ResponseEntity<List<Auto>> getAutosByPrecio(@PathVariable("precioMin") Double precioMin) {
        try {
            List<Auto> autos = autoRepository.findByPrecioGreaterThan(precioMin);
            return ResponseEntity.ok(autos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @DeleteMapping("/auto/{noSerie}")
    public ResponseEntity<?> deleteAuto(@PathVariable("noSerie") String noSerie) {
        if (autoRepository.existsById(noSerie)) {
            autoRepository.deleteById(noSerie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/auto")
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
        if (auto.getMarca() == null || auto.getMarca().getIdMarca() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Optional<Marca> marca = marcaRepository.findById(auto.getMarca().getIdMarca());
        if (marca.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        auto.setMarca(marca.get());
        Auto savedAuto = autoRepository.save(auto);
        return ResponseEntity.ok(savedAuto);
    }
    
    @GetMapping("/autos")
    public ResponseEntity<List<Auto>> getAllAutos() {
        List<Auto> autos = autoRepository.findAllWithMarca();
        return ResponseEntity.ok(autos);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("API is running");
    }
}