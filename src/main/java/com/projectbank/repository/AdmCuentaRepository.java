package com.projectbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;

public interface AdmCuentaRepository extends JpaRepository<AdmCuenta, String>{

	public List<AdmCuenta> findByCedulaCliente(Cliente cedulaCliente);
}
