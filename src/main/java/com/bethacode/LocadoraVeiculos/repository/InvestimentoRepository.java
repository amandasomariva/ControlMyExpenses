package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> , QuerydslPredicateExecutor<Investimento> {

    List<Investimento> findBySaldo(Double saldo);

    List<Investimento> findByParcelas(String parcelas);

    List<Investimento> findByRendimento(Integer rendimento);
}
