package com.projectbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbank.model.Cliente;
import com.projectbank.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodo() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		Cliente cliente = clienteRepository.findByCedula(cedula);
		System.out.println(cliente);
		return cliente;
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		clienteRepository.deleteById(cedula);
	}

}
