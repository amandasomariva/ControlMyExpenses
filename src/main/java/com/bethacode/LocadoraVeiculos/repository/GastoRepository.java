package com.bethacode.LocadoraVeiculos.repository;


import com.bethacode.LocadoraVeiculos.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long>, QuerydslPredicateExecutor<Gasto> {

    List<Gasto> findByDescricaoCompra(String descricaoCompra);

    List<Gasto> findByValorCompra(Double valorCompra);

    List<Gasto> findByDataCompra(LocalDate dataCompra);

    List<Gasto> findByDataVencimento(LocalDate dataVencimento);

    List<Gasto> findByTipoPagamento(TipoPagamento tipoPagamento);

    List<Gasto> findByTipoDespesa(TipoDespesa tipoDespesa);

    List<Gasto> findByPago(boolean pago);

}