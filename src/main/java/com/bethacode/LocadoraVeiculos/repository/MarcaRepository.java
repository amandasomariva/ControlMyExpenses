package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> , QuerydslPredicateExecutor<Marca> {

    List<Marca> findByNome(String nome);
}
