package com.projectbank.service;

import java.util.List;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;

public interface AdmCuentaService {

	public List<AdmCuenta> listarTodos();
	
	public List<AdmCuenta> listaPorCedula(Cliente cedula);
	
	public void guardar(AdmCuenta admCuenta);
}
