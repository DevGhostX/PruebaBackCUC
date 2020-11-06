package com.soaint.prueba.venta.controller;

import com.soaint.prueba.venta.entity.Producto;
import com.soaint.prueba.venta.service.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class ProductoController {

    private static final Logger LOGGER = LogManager.getLogger(ProductoController.class);

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("productos")
    public List<Producto> listarProductos() {
        LOGGER.info("listando productos");
        return productoService.listarProductos();
    }

    @GetMapping("productos/{idProducto}")
    public ResponseEntity<?> buscarProducto(@PathVariable int idProducto) {
        Producto producto;
        Map<String, Object> response = new HashMap<>();
        try {
            producto = productoService.buscarProducto(idProducto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al consultar en la base de datos");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (producto == null){
            response.put("mensaje", "No existe el producto");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("productos")
    public ResponseEntity<?> guardarProducto(@Valid @RequestBody Producto producto) {
        Producto nuevoProducto;
        Map<String, Object> response = new HashMap<>();
        try {
            nuevoProducto = productoService.guardarProducto(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar el producto en la base de datos");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Producto creado con éxito!");
        response.put("producto", nuevoProducto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("productos/{idProducto}")
    public ResponseEntity<?> actualizarProducto(@Valid @RequestBody Producto producto, @PathVariable int idProducto) {
        Producto productoActual = productoService.buscarProducto(idProducto);
        Producto productoActualizado;
        Map<String, Object> response = new HashMap<>();
        if (productoActual == null){
            response.put("mensaje", "No se pudo editar el producto, no existe en la base de datos");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoActualizado = productoService.guardarProducto(productoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el producto");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Producto actualizado con éxito!");
        response.put("producto", productoActualizado);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("productos/{idProducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int idProducto) {
        Map<String, Object> response = new HashMap<>();
        try {
            productoService.eliminarProducto(idProducto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el producto");
            response.put("error", Objects.requireNonNull(e.getMessage()).concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Producto eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
