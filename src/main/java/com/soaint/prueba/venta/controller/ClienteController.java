package com.soaint.prueba.venta.controller;

import com.soaint.prueba.venta.entity.Cliente;
import com.soaint.prueba.venta.service.ClienteService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("clientes")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente;
        Map<String, Object> response = new HashMap<>();
        try {
            nuevoCliente = clienteService.guardarCliente(cliente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Cliente creado con éxito!");
        response.put("cliente", nuevoCliente);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
