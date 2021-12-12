package com.bethacode.LocadoraVeiculos.repository;


import com.bethacode.LocadoraVeiculos.model.Sexo;
import com.bethacode.LocadoraVeiculos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QuerydslPredicateExecutor<Usuario> {

    List<Usuario> findByNome(String nome);

    List<Usuario> findByDataNascimento(LocalDate dataNascimento);

    List<Usuario> findBySexo(Sexo sexo);

    List<Usuario> findByCpf(String cpf);

    List<Usuario> findByEmail(String email);

}