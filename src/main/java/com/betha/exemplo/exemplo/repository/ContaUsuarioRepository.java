package com.betha.exemplo.exemplo.repository;

import com.betha.exemplo.exemplo.model.ContaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaUsuarioRepository extends JpaRepository<ContaUsuario, Long> {
}
