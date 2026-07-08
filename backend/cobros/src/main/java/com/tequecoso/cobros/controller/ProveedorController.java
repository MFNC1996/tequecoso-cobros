package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.Proveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private List<Proveedor> proveedores = new ArrayList<>();

    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedores;
    }

    @PostMapping
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor) {
        proveedores.add(proveedor);
        return proveedor;
    }
}
