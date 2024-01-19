package com.example.demoHexa.src.adapter.out.persistence;

import com.example.demoHexa.src.application.domain.entity.Honey;
import com.example.demoHexa.src.application.port.out.HoneyOutputPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
    Data Layer
*/
@Repository
@Component
public interface HoneyRepository extends JpaRepository<Honey, Long>, HoneyOutputPort {
}

/*
    - Optional<Honey> findById(Long id);
    - List<Honey> findAll();
    - void save(Honey);
*/
