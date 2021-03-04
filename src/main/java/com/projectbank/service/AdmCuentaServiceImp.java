package com.projectbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;
import com.projectbank.repository.AdmCuentaRepository;

@Service
public class AdmCuentaServiceImp implements AdmCuentaService {

	@Autowired
	AdmCuentaRepository admCuentaRepository;

	@Override
	public List<AdmCuenta> listarTodos() {

		return admCuentaRepository.findAll();
	}

	@Override
	public List<AdmCuenta> listaPorCedula(Cliente cedula) {
		return admCuentaRepository.findByCedulaCliente(cedula);
	}

	@Override
	public void guardar(AdmCuenta admCuenta) {
		admCuentaRepository.save(admCuenta);
		
	}

}
