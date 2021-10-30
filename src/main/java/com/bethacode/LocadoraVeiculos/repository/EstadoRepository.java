package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
