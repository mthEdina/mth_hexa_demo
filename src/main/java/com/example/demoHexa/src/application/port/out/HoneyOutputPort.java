package com.example.demoHexa.src.application.port.out;

import com.example.demoHexa.src.application.domain.entity.Honey;

import java.util.List;
import java.util.Optional;

public interface HoneyOutputPort {
    List<Honey> findAll();

    Optional<Honey> findById(Long id);

    Honey save(Honey honey);
    void delete(Honey honey);
}
