package com.projectbank.service;

import java.util.List;

import com.projectbank.model.Ciudad;



public interface CiudadService {

	public List<Ciudad> buscarTodos();

	public Ciudad buscarCiudadPorCodigo(String codigo);

	public Ciudad buscarCiudadPorNombre(String nombre);
}
	