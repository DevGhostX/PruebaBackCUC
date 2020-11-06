package com.soaint.prueba.venta.service;

import com.soaint.prueba.venta.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardarProducto(Producto producto);
    void eliminarProducto(int idProducto);
    List<Producto> listarProductos();
    Producto buscarProducto(int idProducto);
}
