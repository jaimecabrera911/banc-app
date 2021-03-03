package com.projectbank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectbank.model.Cuenta;
import com.projectbank.model.Movimiento;

import com.projectbank.repository.CuentaRepository;

import com.projectbank.repository.MovimientoRepository;


@SpringBootTest
class ProjectBankApplicationTests {
	
	@Autowired
	MovimientoRepository movrep;

	@Autowired
	CuentaRepository cuentaRepository;


	@Test
	void contextLoads() {
		
		var cuenta=new Cuenta();
		cuenta.setCodigo("002");
		
		var list=movrep.findByCuenta(cuenta);
		
		for (Movimiento movimiento : list) {
			System.out.println(movimiento);
		}
	
	}
}
