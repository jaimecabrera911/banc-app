package com.projectbank.service;

import java.util.List;

<<<<<<< HEAD
import com.projectbank.model.Cliente;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import com.projectbank.model.Cuenta;

public interface CuentaService {

	public List<Cuenta> listarTodo();

	public Cuenta listarPorCodigo(String codigo);

	public void guardar(Cuenta cuenta);
<<<<<<< HEAD
	
	
	public List<Cuenta> listarPorCedula(Cliente cedula);
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

}
