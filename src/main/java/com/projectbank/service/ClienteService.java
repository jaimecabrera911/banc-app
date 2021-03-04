package com.projectbank.service;

import java.util.List;

import com.projectbank.model.Cliente;

public interface ClienteService {

	public List<Cliente> listarTodo();

	public void guardar(Cliente cliente);

	public Cliente buscarPorCedula(String cedula);
	
	public void eliminarPorCedula(String cedula);

}
