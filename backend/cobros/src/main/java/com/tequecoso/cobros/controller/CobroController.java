package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.Cobro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cobros")
public class CobroController {

    private List<Cobro> cobros = new ArrayList<>();

    @GetMapping
    public List<Cobro> listarCobros() {
        return cobros;
    }

    @PostMapping
    public Cobro agregarCobro(@RequestBody Cobro cobro) {
        cobros.add(cobro);
        return cobro;
    }
}
