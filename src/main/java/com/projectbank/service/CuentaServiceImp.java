package com.projectbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbank.model.Cliente;
import com.projectbank.model.Cuenta;
import com.projectbank.repository.CuentaRepository;

@Service
public class CuentaServiceImp implements CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> listarTodo() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta listarPorCodigo(String codigo) {
        return cuentaRepository.findByCodigo(codigo);
    }

    @Override
    public void guardar(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override

    public List<Cuenta> listarPorCedula(Cliente cliente) {
        // TODO Auto-generated method stub
        return cuentaRepository.findByCedula(cliente);
    }

}
