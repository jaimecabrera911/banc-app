package com.projectbank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbank.model.Cliente;
import com.projectbank.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ApiClienteController {

	@Autowired
	ClienteService clienteService;


	@GetMapping("/")
	public  List<Cliente> listarClientes() {
		return clienteService.listarTodo();
	}



}
