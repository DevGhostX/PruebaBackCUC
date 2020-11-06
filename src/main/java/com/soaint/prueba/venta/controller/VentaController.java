package com.soaint.prueba.venta.controller;

import com.soaint.prueba.venta.entity.Venta;
import com.soaint.prueba.venta.service.VentaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("ventas")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("ventas/{idVenta}")
    public ResponseEntity<?> buscarVenta(@PathVariable int idVenta) {
        Venta venta;
        Map<String, Object> response = new HashMap<>();
        try {
            venta = ventaService.buscarVenta(idVenta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar en la base de datos");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (venta == null){
            response.put("mensaje", "No existe la venta");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }

    @PostMapping("ventas")
    public ResponseEntity<?> guardarVenta(@Valid @RequestBody Venta venta) {
        Venta nuevaVenta;
        Map<String, Object> response = new HashMap<>();
        try {
            nuevaVenta = ventaService.guardarVenta(venta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar la venta");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Venta creada con éxito!");
        response.put("venta", nuevaVenta);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
