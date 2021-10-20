package com.bethacode.LocadoraVeiculos.repository;

import com.bethacode.LocadoraVeiculos.model.Cliente;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByTipoDocumento(String tipoDocumento);

    List<Cliente> findByDocumento(String documento);

    List<Cliente> findByDataNascimento(String dataNascimento);
}