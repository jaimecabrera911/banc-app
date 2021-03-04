package com.projectbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectbank.model.Cliente;
import com.projectbank.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
    
	public List<Cuenta> findByCedula(Cliente cedulaCliente);
	public List<Cuenta> findByEstado(Boolean estado);
	public Cuenta findByCodigo(String codigo);
	

}
