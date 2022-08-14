package com.kriptopedija.Controllers;

import com.kriptopedija.Models.Crypto;
import com.kriptopedija.Models.News;
import com.kriptopedija.Service.CryptoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping(value = {"/crypto"})
@AllArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping
    private List<Crypto> findAll(){
        return cryptoService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Crypto> findById(@PathVariable String name){
        return cryptoService.findById(name)
                .map(crypto -> ResponseEntity.ok().body(crypto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
