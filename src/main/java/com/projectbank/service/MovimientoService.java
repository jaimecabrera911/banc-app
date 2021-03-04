package com.projectbank.service;

import java.util.Date;
import java.util.List;

import com.projectbank.model.Cuenta;
import java.util.List;

import com.projectbank.model.Movimiento;

public interface MovimientoService {

    public List<Movimiento> buscarTodo();

    public List<Movimiento> buscarPorCodigo(String codigo);

    public void guardar(Movimiento movimiento);

    public long contar();

    public Double sumarSaldo(Cuenta cuenta);

    public Double saldo(Cuenta cuenta);

    public List<Movimiento> buscarPorFechaEntre(Date fechaIni, Date fechaFin);

}
