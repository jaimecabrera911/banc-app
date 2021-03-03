package com.projectbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectbank.model.Cliente;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(Cliente cliente, HttpSession session){
    	session.setAttribute("usuario", cliente);
        return "index";
    }	
}
