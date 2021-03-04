package com.projectbank.service;

import java.util.List;

import com.projectbank.model.Cliente;
import com.projectbank.model.Cuenta;

public interface CuentaService {

	public List<Cuenta> listarTodo();

	public Cuenta listarPorCodigo(String codigo);

	public void guardar(Cuenta cuenta);
	
	public List<Cuenta> listarPorCedula(Cliente cliente);
	
	public void eliminarPorCodigo(String codigo);

}
