package com.kriptopedija.Repository;

import com.kriptopedija.Models.Crypto;
import com.kriptopedija.Models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, String> {

}