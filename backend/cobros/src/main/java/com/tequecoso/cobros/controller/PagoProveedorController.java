package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.PagoProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pagos-proveedor")
public class PagoProveedorController {

    private List<PagoProveedor> pagosProveedor = new ArrayList<>();

    @GetMapping
    public List<PagoProveedor> listarPagosProveedor() {
        return pagosProveedor;
    }

    @PostMapping
    public PagoProveedor agregarPagoProveedor(@RequestBody PagoProveedor pagoProveedor) {
        pagosProveedor.add(pagoProveedor);
        return pagoProveedor;
    }
}
