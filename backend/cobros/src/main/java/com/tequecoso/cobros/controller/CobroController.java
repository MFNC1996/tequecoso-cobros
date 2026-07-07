package com.tequecoso.cobros.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cobros")
public class CobroController {

    private List<String> cobros = new ArrayList<>();

    @GetMapping
    public List<String> listarCobros() {
        return cobros;
    }

    @PostMapping
    public String agregarCobro(@RequestBody String cobro) {
        cobros.add(cobro);
        return "Cobro registrado: " + cobro;
    }
}
