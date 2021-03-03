package com.projectbank.service;

import java.util.List;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;

public interface AdmCuentaService {

	public List<AdmCuenta> listarTodos();
	
	public List<AdmCuenta> listaPorCedula(Cliente cedula);
<<<<<<< HEAD
	
	public void guardar(AdmCuenta admCuenta);
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
