package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Locacao;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    List<Locacao> findByData(LocalDate data);

    List<Locacao> findByInicioPerido(LocalDate inicioPerido);

    List<Locacao> findByFimPeriodo(LocalDate fimPeriodo);

}
