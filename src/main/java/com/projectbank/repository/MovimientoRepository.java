package com.projectbank.repository;

import com.projectbank.model.Cuenta;
import com.projectbank.model.Movimiento;
import com.projectbank.model.MovimientoPK;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, MovimientoPK> {

	public List<Movimiento> findByCuenta(Cuenta cuenta);

<<<<<<< HEAD
	public Double sumSaldo(Cuenta cuenta);
	
	public List<Movimiento> findByFechaMovBetween(Date fechaIni,Date fechafin);

=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
