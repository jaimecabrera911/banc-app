package com.projectbank.repository;

import com.projectbank.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {
    public Ciudad findByNombre(String nombre);
}
