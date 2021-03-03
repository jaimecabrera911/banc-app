package com.projectbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;
import com.projectbank.model.Cuenta;
import com.projectbank.service.AdmCuentaService;
import com.projectbank.service.ClienteService;
import com.projectbank.service.CuentaService;

@Controller
@RequestMapping("/admcuentas")
public class AdmCuentaController {

	@Autowired
	AdmCuentaService admCuentaService;


	@Autowired
	CuentaService cuentaService;

	@Autowired
	ClienteService clienteService;

	@GetMapping("")
	public String listarCuentasPorCedula(HttpSession session, Model model) {


		List<AdmCuenta> listaAdmCuentas = admCuentaService.listarTodos();
		model.addAttribute("cuentas", listaAdmCuentas);
		return "views/admcuentas/list";
	}

	@GetMapping("/form")
	public String formAdmCuenta(AdmCuenta admCuenta, Model model) {
		List<Cuenta> listarCuentas = cuentaService.listarTodo();
		List<Cliente> listarClientes = clienteService.listarTodo();
		model.addAttribute("cuentas", listarCuentas);
		model.addAttribute("clientes", listarClientes);
		return "/views/admcuentas/form";

	}

	@PostMapping("/guardar")
	public String guardar(AdmCuenta admCuenta, RedirectAttributes attributes) {
		admCuentaService.guardar(admCuenta);
		System.out.println(admCuenta);
		attributes.addFlashAttribute("guardado", "Cuenta asignada correctamente.");
		return "redirect:/admcuentas";

	}


}
