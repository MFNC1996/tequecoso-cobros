package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }
}
