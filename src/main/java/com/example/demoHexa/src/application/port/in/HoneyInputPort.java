package com.example.demoHexa.src.application.port.in;

import com.example.demoHexa.src.application.domain.entity.Honey;

import java.util.List;
import java.util.Optional;

public interface HoneyInputPort {
    List<Honey> getAllProducts();

    Optional<Honey> getProductById(Long id);

    boolean buyProduct(Long id);

    boolean addProduct(Honey product);

    boolean increaseProduct(Long id, int nr);
}
