package com.projectbank.repository;

import com.projectbank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
	public Cliente findByCedula(String cedula);
}
