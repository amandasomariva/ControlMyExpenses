package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Estado;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> , QuerydslPredicateExecutor<Estado> {
}
