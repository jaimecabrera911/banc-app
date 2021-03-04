package com.projectbank.controller;


import com.projectbank.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.projectbank.model.Cuenta;
import com.projectbank.service.CuentaService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cuentas")

public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public String listarCuentas(Model model) {

        Cliente session = (Cliente) httpSession.getAttribute("usuario");
        model.addAttribute("rol",session.getRol());
        if (session.getRol().equals("ADMON")) {
            model.addAttribute("listaCuentas", cuentaService.listarTodo());
        } else {
            model.addAttribute("listaCuentas", cuentaService.listarPorCedula(session));
        }

        return "views/cuentas/list";
    }

    @GetMapping("/form")
    public String form(Cuenta cuenta, Model model) {
        return "views/cuentas/form";
    }

    @PostMapping("/guardar")
    public String guardar(Cuenta cuenta, RedirectAttributes attributes) {
        cuentaService.guardar(cuenta);
        attributes.addFlashAttribute("guardado", "Cuenta creada exitosamente");
        return "redirect:/cuentas/";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable String codigo, RedirectAttributes attributes) {
    	Cuenta cuenta = cuentaService.listarPorCodigo(codigo);
    	System.out.println("CUENTA"+cuenta);
        attributes.addFlashAttribute("cuenta", cuenta);
        return "redirect:/cuentas/form";
    }
}
