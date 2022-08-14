package com.kriptopedija.Service;

import com.kriptopedija.Models.Crypto;

import java.util.List;
import java.util.Optional;

public interface CryptoService {

    List<Crypto> findAll();
    Optional<Crypto> findById(String name);
    Optional<Crypto> save(Crypto crypto);
    Optional<Crypto> edit(Crypto crypto);
    void deleteById(String name);

}
