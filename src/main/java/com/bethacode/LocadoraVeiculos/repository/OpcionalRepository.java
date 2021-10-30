package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Long> {

    List<Opcional> findByNome(String nome);

    List<Opcional> findByDescricao(String descricao);
}

