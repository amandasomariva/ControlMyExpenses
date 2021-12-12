package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Resumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, Long> , QuerydslPredicateExecutor<Resumo> {

    List<Resumo> findByDataSaida(LocalDate dataSaida);

    List<Resumo> findByValorTotal(String valorTotal);

    List<Resumo> findBySaldoTotal(String saldoTotal);


}
