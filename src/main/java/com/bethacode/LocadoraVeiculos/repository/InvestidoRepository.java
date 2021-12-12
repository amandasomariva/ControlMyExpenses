package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvestidoRepository extends JpaRepository<Investido, Long> , QuerydslPredicateExecutor<Investido> {

    List<Investido> findByValorInvestido(Double valorInvestido);

    List<Investido> findByDataInvestido(LocalDate dataInvestido);
}
