package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.Cliente;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "*")
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

    @PostMapping("/iniciar-proceso")
    public ResponseEntity<String> iniciarProceso(@RequestBody Cliente cliente) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/flowable-task/process-api/runtime/process-instances";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("admin", "test");

        Map<String, Object> body = new HashMap<>();
        body.put("processDefinitionKey", "registroDeClientes");

        List<Map<String, Object>> variables = new ArrayList<>();
        variables.add(Map.of("name", "nombre", "value", cliente.getNombre(), "type", "string"));
        variables.add(Map.of("name", "telefono", "value", cliente.getTelefono(), "type", "string"));
        variables.add(Map.of("name", "direccion", "value", cliente.getDireccion(), "type", "string"));
        variables.add(Map.of("name", "observacion", "value",
                cliente.getObservacion() == null ? "" : cliente.getObservacion(), "type", "string"));
        body.put("variables", variables);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}