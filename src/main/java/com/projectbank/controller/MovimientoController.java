package com.projectbank.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.projectbank.model.AdmCuenta;
import com.projectbank.model.Cliente;
import com.projectbank.model.Cuenta;
import com.projectbank.model.Movimiento;
import com.projectbank.model.MovimientoPK;
import com.projectbank.service.AdmCuentaService;
import com.projectbank.service.MovimientoService;
import com.projectbank.util.MovimientoExcelExporter;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;

    @Autowired
    AdmCuentaService admCuentaService;

    @Autowired
    HttpSession httpSession;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }

    @GetMapping("")
    public String listarMovimientos(Model model) {
        model.addAttribute("movimientos", movimientoService.buscarTodo());
        return "views/movimientos/list";
    }

    @GetMapping("/{codigo}")
    public String listarMovimientoPorCodigo(@PathVariable String codigo, Model model) {
        Cliente cliente=(Cliente) httpSession.getAttribute("usuario");
        model.addAttribute(codigo);
    	Double acumulado = 0.0;
        List<Movimiento> movimientos = movimientoService.buscarPorCodigo(codigo);
        model.addAttribute("movimientos", movimientos);
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipoMovimiento().equalsIgnoreCase("ingreso")) {
                acumulado += movimiento.getSaldo();
            } else if (movimiento.getTipoMovimiento().equalsIgnoreCase("egreso")) {
                acumulado -= movimiento.getSaldo();
            }
        }

        model.addAttribute("saldo", acumulado);
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
        movimientoPK.setId((int) movimientoService.contar() + 1);
        movimientoPK.setCedulaCli(usuario.getCedula());
        movimientoPK.setCodigoCta(movimiento.getCuenta().getCodigo());
        movimiento.setMovimientoPK(movimientoPK);
        movimiento.setFechaMov(new Date());
        Cuenta cuenta = new Cuenta();
        cuenta.setCodigo(movimiento.getCuenta().getCodigo());
        System.out.println(movimientoService.saldo(cuenta));
        System.out.println(movimiento.getTipoMovimiento().equalsIgnoreCase("egreso"));
        if (movimiento.getTipoMovimiento().equalsIgnoreCase("egreso")
                && movimientoService.saldo(cuenta) < movimiento.getSaldo()) {
        	attribute.addFlashAttribute("rechazado", "El valor ingresado es mayor al saldo");
            return "redirect:/movimientos/" + movimiento.getCuenta().getCodigo();
        }
        movimientoService.guardar(movimiento);
        attribute.addFlashAttribute("guardado", "Transaccion exitosa");
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
    
    @GetMapping("/export/{codigo}")
    public String exportToExcelByCodigo(HttpServletResponse response,@PathVariable String codigo) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=movimientos_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Movimiento> listMovimientos = movimientoService.buscarPorCodigo(codigo);

        MovimientoExcelExporter excelExporter = new MovimientoExcelExporter(listMovimientos);

        excelExporter.export(response);

        return "redirect:/movimientos";
    }

    @GetMapping("/fecha")
    public String buscarPorFechaEntre(@RequestParam String fechaIni, @RequestParam String fechaFin, Model model, RedirectAttributes attributes)
            throws ParseException {

        try {
            System.out.println(fechaIni + " - " + fechaFin);
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaIni);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
            List<Movimiento> movimientos = movimientoService.buscarPorFechaEntre(date1, date2);
            model.addAttribute("movimientos", movimientos);
            return "views/movimientos/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getCause());
            return "views/movimientos/list";
        }
    }

}
