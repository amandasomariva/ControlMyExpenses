package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> , QuerydslPredicateExecutor<Modelo> {

    List<Modelo> findByNome(String nome);

    List<Modelo> findByMotor(String motor);

    List<Modelo> findByHp(String hp);

    List<Modelo> findByMarca(String marca);
}
