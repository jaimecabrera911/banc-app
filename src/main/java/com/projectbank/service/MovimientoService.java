package com.projectbank.service;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import com.projectbank.model.Cuenta;
=======
import java.util.List;

>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import com.projectbank.model.Movimiento;

public interface MovimientoService {

	public List<Movimiento> buscarTodo();
<<<<<<< HEAD

	public List<Movimiento> buscarPorCodigo(String codigo);

	public void guardar(Movimiento movimiento);

	public long contar();

	public Double sumarSaldo(Cuenta cuenta);

	public Double saldo(Cuenta cuenta);

	public List<Movimiento> buscarPorFechaEntre(Date fechaIni, Date fechaFin);

=======
	
	public List<Movimiento> buscarPorCodigo(String codigo);
	
	public void guardar(Movimiento movimiento);
	
	public long contar();

>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
