package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Exceptions.CryptoNotFoundException;
import com.kriptopedija.Models.Crypto;
import com.kriptopedija.Repository.CryptoRepository;
import com.kriptopedija.Service.CryptoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CryptoServiceImpl implements CryptoService{

    private final CryptoRepository cryptoRepository;


    @Override
    public List<Crypto> findAll() {
        return cryptoRepository.findAll();
    }

    @Override
    public Optional<Crypto> findById(String name) {
        return cryptoRepository.findById(name);
    }

    @Override
    public Optional<Crypto> save(Crypto crypto) {
        cryptoRepository.save(crypto);
        return Optional.of(crypto);
    }

    @Override
    public Optional<Crypto> edit(Crypto crypto) {
        Crypto theCrypto = cryptoRepository.findById(crypto.getName())
                .orElseThrow(() -> new CryptoNotFoundException(crypto.getName()));

        theCrypto.setName(crypto.getName());
        theCrypto.setCode(crypto.getCode());
        theCrypto.setPrice(crypto.getPrice());
        theCrypto.setCirculatingSupply(crypto.getCirculatingSupply());
        theCrypto.setWebsite(crypto.getWebsite());
        theCrypto.setMinable(crypto.getMinable());
        theCrypto.setAlgorithm(crypto.getAlgorithm());

        cryptoRepository.save(theCrypto);
        return Optional.of(theCrypto);
    }

    @Override
    public void deleteById(String name) {
        cryptoRepository.deleteById(name);
    }
}
