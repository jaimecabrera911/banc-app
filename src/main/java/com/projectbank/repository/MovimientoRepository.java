package com.projectbank.repository;

import com.projectbank.model.Cuenta;
import com.projectbank.model.Movimiento;
import com.projectbank.model.MovimientoPK;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, MovimientoPK> {

	public List<Movimiento> findByCuenta(Cuenta cuenta);

	public Double sumSaldo(Cuenta cuenta);
	
	public List<Movimiento> findByFechaMovBetween(Date fechaIni,Date fechafin);

}
