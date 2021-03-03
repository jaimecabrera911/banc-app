/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectbank.api.controller;

import com.projectbank.model.Movimiento;
import com.projectbank.repository.MovimientoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desarrolladorweb6
 */
@RestController
@RequestMapping("/api/movimientos")
public class ApiMovimientoController {
    
    @Autowired
    MovimientoRepository movimientoRepository;
    
    @GetMapping("")
    public List<Movimiento> listarMovimientos(){
    	return movimientoRepository.findAll();
    }
    
}
