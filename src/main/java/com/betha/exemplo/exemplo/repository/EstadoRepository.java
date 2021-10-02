package com.betha.exemplo.exemplo.repository;

import com.betha.exemplo.exemplo.model.Estado;
import com.betha.exemplo.exemplo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
