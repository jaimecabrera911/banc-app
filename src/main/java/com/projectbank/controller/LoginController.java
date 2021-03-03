package com.projectbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectbank.model.Cliente;
import com.projectbank.service.ClienteService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public String formLogin(Cliente cliente) {
		return "views/login/form";
	}

	@PostMapping
	public String login(@ModelAttribute Cliente cliente, HttpSession session, RedirectAttributes attribute) {
		String _cedula = cliente.getCedula();
		if (clienteService.buscarPorCedula(_cedula) != null) {

			if (cliente.getPassword().equals(clienteService.buscarPorCedula(_cedula).getPassword())) {

				var _cliente = clienteService.buscarPorCedula(cliente.getCedula());
				session.setAttribute("usuario", _cliente);
				String rol = _cliente.getRol();

				switch (rol) {
				case "ADMON":
					return "redirect:/clientes/";
				case "CLIENTE":
					return "redirect:/admcuentas";
				}
			}

		}
		attribute.addFlashAttribute("error", "Tu usuario o contraseña son incorrectos");
		return "redirect:/";

	}

	@GetMapping("/logout")
	public String logout(Cliente cliente, HttpSession session) {
		session.setAttribute("usuario", null);
		return "redirect:/";
	}

}
