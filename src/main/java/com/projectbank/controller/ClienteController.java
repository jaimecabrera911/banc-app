package com.projectbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;
import com.projectbank.service.AdmCuentaService;

import com.projectbank.service.CiudadService;
import com.projectbank.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	CiudadService ciudadService;

	@Autowired
	AdmCuentaService admCuentaService;

	@GetMapping("/")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", clienteService.listarTodo());
		return "views/clientes/lista";
	}

	@GetMapping("/form")
	public String formulario(Cliente cliente, Model model) {
		System.out.println(cliente);
		model.addAttribute("ciudades", ciudadService.buscarTodos());
		return "views/clientes/form";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Cliente cliente, Model model, RedirectAttributes attributes) {
		clienteService.guardar(cliente);
		attributes.addFlashAttribute("ok", "Cliente guardado con éxito!");
		return "redirect:/clientes/";
	}

	@GetMapping("/eliminar/{cedula}")
	public String eliminar(@PathVariable String cedula, RedirectAttributes attributes) {
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		List<AdmCuenta> cuentas = admCuentaService.listaPorCedula(cliente);
		if (!cuentas.isEmpty()) {
			attributes.addFlashAttribute("error", "El cliente tiene cuentas asociadas!");
			return "redirect:/clientes/";
		}
		clienteService.eliminarPorCedula(cedula);
		attributes.addFlashAttribute("ok", "Cliente eliminado con éxito!");
		return "redirect:/clientes/";

	}

	@GetMapping("/editar/{cedula}")
	public String editar(@PathVariable String cedula, RedirectAttributes attributes) {
		Cliente cliente = clienteService.buscarPorCedula(cedula);
		attributes.addFlashAttribute("cliente", cliente);
		System.out.println("CLIENTE: "+cliente);
		return "redirect:/clientes/form";
	}

}
