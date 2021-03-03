package com.projectbank.service;

import java.util.List;

import com.projectbank.model.Cliente;

public interface ClienteService {

	public List<Cliente> listarTodo();

	public void guardar(Cliente cliente);

	public Cliente buscarPorCedula(String cedula);
<<<<<<< HEAD
	
	public void eliminarPorCedula(String cedula);
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

}
