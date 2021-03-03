package com.projectbank.repository;

import com.projectbank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
<<<<<<< HEAD
	public Cliente findByCedula(String cedula);

	
=======
    public Cliente findByCedula(String cedula);
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
