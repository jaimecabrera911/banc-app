package com.projectbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbank.model.Ciudad;
import com.projectbank.repository.CiudadRepository;

@Service
public class CiudadServiceImp implements CiudadService{

	@Autowired
	CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> buscarTodos() {
		// TODO Auto-generated method stub
		return ciudadRepository.findAll();
	}

	@Override
	public Ciudad buscarCiudadPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad buscarCiudadPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
