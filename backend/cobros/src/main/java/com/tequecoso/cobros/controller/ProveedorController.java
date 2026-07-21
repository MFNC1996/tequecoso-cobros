package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.Proveedor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "*")
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

    @PostMapping("/iniciar-proceso")
    public ResponseEntity<String> iniciarProceso(@RequestBody Proveedor proveedor) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/flowable-task/process-api/runtime/process-instances";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("admin", "test");

        Map<String, Object> body = new HashMap<>();
        body.put("processDefinitionKey", "registrarProveedor");

        List<Map<String, Object>> variables = new ArrayList<>();
        variables.add(Map.of("name", "nombre", "value", proveedor.getNombre(), "type", "string"));
        variables.add(Map.of("name", "telefono", "value", proveedor.getTelefono(), "type", "string"));
        variables.add(Map.of("name", "direccion", "value", proveedor.getDireccion(), "type", "string"));
        variables.add(Map.of("name", "observacion", "value",
                proveedor.getObservacion() == null ? "" : proveedor.getObservacion(), "type", "string"));
        body.put("variables", variables);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}