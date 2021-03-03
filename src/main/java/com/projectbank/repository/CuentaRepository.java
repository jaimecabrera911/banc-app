package com.projectbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import com.projectbank.model.Cliente;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import com.projectbank.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
    
<<<<<<< HEAD
	Cuenta findByCodigo(String codigo);
	List<Cuenta> findByCedula(Cliente cedulaCliente);
	List<Cuenta> findByEstado(Boolean estado);
=======
	List<Cuenta> findByCodigo(String codigo);
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

}
