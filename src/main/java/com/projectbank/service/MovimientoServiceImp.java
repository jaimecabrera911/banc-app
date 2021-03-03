package com.projectbank.service;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbank.model.Cuenta;
import com.projectbank.model.Movimiento;
import com.projectbank.repository.MovimientoRepository;

@Service
public class MovimientoServiceImp implements MovimientoService{
	
	@Autowired
	MovimientoRepository movimientoRepository;
	

	@Override
	public List<Movimiento> buscarTodo() {
		// TODO Auto-generated method stub
		return movimientoRepository.findAll();
	}

	@Override
	public List<Movimiento> buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		
		Cuenta cuenta=new Cuenta();
		
		cuenta.setCodigo(codigo);
		
		return movimientoRepository.findByCuenta(cuenta);
	}

	@Override
	public void guardar(Movimiento movimiento) {
		movimientoRepository.save(movimiento);
	}

	@Override
	public long contar() {
		
		return movimientoRepository.count();
	}

<<<<<<< HEAD
	@Override
	public Double sumarSaldo(Cuenta cuenta) {
		
		return movimientoRepository.sumSaldo(cuenta);
	}


	@Override
	public Double saldo(Cuenta cuenta) {
		System.out.println("Saldo");
		double acumulado=0.0;
		List<Movimiento> movimientos = movimientoRepository.findByCuenta(cuenta);
		for (Movimiento movimiento : movimientos) {
			System.out.println(movimiento);
			if (movimiento.getTipoMovimiento().equalsIgnoreCase("ingreso")) {
				acumulado += movimiento.getSaldo();
				System.out.println(movimiento);
			} else if (movimiento.getTipoMovimiento().equalsIgnoreCase("egreso")) {
				acumulado -= movimiento.getSaldo();
				System.out.println(movimiento);
			}
		}
		return acumulado;
	}

	@Override
	public List<Movimiento> buscarPorFechaEntre(Date fechaIni, Date fechaFin) {
		
		return movimientoRepository.findByFechaMovBetween(fechaIni, fechaFin);
	}

=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
	

}
