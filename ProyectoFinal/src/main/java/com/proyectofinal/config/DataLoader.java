package com.proyectofinal.config;

import com.proyectofinal.entity.Auto;
import com.proyectofinal.entity.Marca;
import com.proyectofinal.repository.AutoRepository;
import com.proyectofinal.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MarcaRepository marcaRepository;
    
    @Autowired
    private AutoRepository autoRepository;

    @Override
    public void run(String... args) throws Exception {
        String port = System.getenv("PORT");
        String baseUrl = port != null ? "https://tu-app.onrender.com" : "http://localhost:8086";
        
        Marca toyota = new Marca("Toyota", "Japón");
        Marca honda = new Marca("Honda", "Japón");
        Marca nissan = new Marca("Nissan", "Japón");
        
        marcaRepository.saveAll(Arrays.asList(toyota, honda, nissan));
        
        Auto auto1 = new Auto("TOY001", "RAV4", 2023, new BigDecimal("450000.00"), toyota);
        Auto auto2 = new Auto("HON001", "CRV", 2024, new BigDecimal("520000.00"), honda);
        Auto auto3 = new Auto("NIS001", "Xtrail", 2023, new BigDecimal("480000.00"), nissan);
        Auto auto4 = new Auto("TOY002", "Corolla", 2024, new BigDecimal("350000.00"), toyota);
        Auto auto5 = new Auto("HON002", "BRV", 2023, new BigDecimal("380000.00"), honda);
        
        autoRepository.saveAll(Arrays.asList(auto1, auto2, auto3, auto4, auto5));
    }
}