package com.projectbank.controller;

<<<<<<< HEAD
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;
<<<<<<< HEAD
import com.projectbank.model.Cuenta;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import com.projectbank.model.Movimiento;
import com.projectbank.model.MovimientoPK;
import com.projectbank.service.AdmCuentaService;
import com.projectbank.service.MovimientoService;
<<<<<<< HEAD
import com.projectbank.util.MovimientoExcelExporter;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {

	@Autowired
	MovimientoService movimientoService;

	@Autowired
	AdmCuentaService admCuentaService;

	@Autowired
	HttpSession httpSession;

<<<<<<< HEAD
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
	}

=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
	@GetMapping("")
	public String listarMovimientos(Model model) {
		model.addAttribute("movimientos", movimientoService.buscarTodo());
		return "views/movimientos/list";
	}

	@GetMapping("/{codigo}")
	public String listarMovimientoPorCodigo(@PathVariable String codigo, Model model) {
		Double acumulado = 0.0;
		List<Movimiento> movimientos = movimientoService.buscarPorCodigo(codigo);
		model.addAttribute("movimientos", movimientos);
		System.out.println(model.getAttribute("movimientos"));
		for (Movimiento movimiento : movimientos) {
			if (movimiento.getTipoMovimiento().equalsIgnoreCase("ingreso")) {
				acumulado += movimiento.getSaldo();
			} else if (movimiento.getTipoMovimiento().equalsIgnoreCase("egreso")) {
				acumulado -= movimiento.getSaldo();
			}
		}
<<<<<<< HEAD
		model.addAttribute("saldo", acumulado);

=======
		
		model.addAttribute("saldo", acumulado);
		
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
		return "views/movimientos/list";
	}

	@GetMapping("/form")
	public String form(Movimiento movimiento, Model model, HttpSession session) {
		Cliente usuario = (Cliente) session.getAttribute("usuario");
		List<AdmCuenta> cuentas = admCuentaService.listaPorCedula(usuario);
		model.addAttribute("cuentas", cuentas);
		return "/views/movimientos/form";

	}

	@PostMapping("/guardar")
	public String guardar(Movimiento movimiento, Model model, HttpSession session, RedirectAttributes attribute) {
		MovimientoPK movimientoPK = new MovimientoPK();
		Cliente usuario = (Cliente) session.getAttribute("usuario");
<<<<<<< HEAD
		movimientoPK.setId((int) movimientoService.contar() + 1);
=======
		movimientoPK.setId((int) movimientoService.contar()+1);
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
		movimientoPK.setCedulaCli(usuario.getCedula());
		movimientoPK.setCodigoCta(movimiento.getCuenta().getCodigo());
		movimiento.setMovimientoPK(movimientoPK);
		movimiento.setFechaMov(new Date());
<<<<<<< HEAD
		Cuenta cuenta = new Cuenta();
		cuenta.setCodigo(movimiento.getCuenta().getCodigo());
		if (movimiento.getTipoMovimiento().equalsIgnoreCase("egreso")
				|| movimientoService.saldo(cuenta) > movimiento.getSaldo()) {
			movimientoService.guardar(movimiento);
			attribute.addFlashAttribute("guardado", "Transaccion exitosa");
			return "redirect:/movimientos/" + movimiento.getCuenta().getCodigo();
		}
		attribute.addFlashAttribute("rechazado", "El valor ingresado es mayor al saldo");
		return "redirect:/movimientos/" + movimiento.getCuenta().getCodigo();

	}

	@GetMapping("/export")
	public String exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=movimientos_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Movimiento> listMovimientos = movimientoService.buscarTodo();

		MovimientoExcelExporter excelExporter = new MovimientoExcelExporter(listMovimientos);

		excelExporter.export(response);

		return "redirect:/movimientos";
	}

	@GetMapping("/fecha")
	public String buscarPorFechaEntre(@RequestParam String fechaIni, @RequestParam String fechaFin, Model model,RedirectAttributes attributes)
			throws ParseException {

		try {
			System.out.println(fechaIni + " - " + fechaFin);
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaIni);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
			List<Movimiento> movimientos = movimientoService.buscarPorFechaEntre(date1, date2);
			model.addAttribute("movimientos", movimientos);
			return "views/movimientos/list";
		} catch (Exception e) {
			model.addAttribute("error",e.getCause());
			return "views/movimientos/list";
		}
=======
		System.out.println(movimiento);
		movimientoService.guardar(movimiento);
		attribute.addFlashAttribute("guardado", "Transaccion exitosa");
		return "redirect:/movimientos/"+movimiento.getCuenta().getCodigo();

>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
	}

}
