package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Renda;
import com.bethacode.LocadoraVeiculos.model.TipoRenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RendaRepository extends JpaRepository<Renda, Long>, QuerydslPredicateExecutor<Renda> {

    List<Renda> findByTipoRenda(TipoRenda tipoRenda);

    List<Renda> findByDataEntrada(LocalDate dataEntrada);

    List<Renda> findByValor(Double valor);

}
