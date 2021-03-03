package com.projectbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.projectbank.model.Cliente;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import com.projectbank.model.Cuenta;
import com.projectbank.repository.CuentaRepository;

@Service
public class CuentaServiceImp implements CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;

	@Override
	public List<Cuenta> listarTodo() {
		return cuentaRepository.findAll();
	}

	@Override
	public Cuenta listarPorCodigo(String codigo) {
<<<<<<< HEAD
		return cuentaRepository.findByCodigo(codigo);
=======
		// TODO Auto-generated method stub
		return (Cuenta) cuentaRepository.findByCodigo(codigo);
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
	}

	@Override
	public void guardar(Cuenta cuenta) {
		cuentaRepository.save(cuenta);
	}

<<<<<<< HEAD
	@Override
	public List<Cuenta> listarPorCedula(Cliente cedula) {
		// TODO Auto-generated method stub
		return cuentaRepository.findByCedula(cedula);
	}


	
	
	

	

=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
