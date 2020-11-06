package com.soaint.prueba.venta.service;

import com.soaint.prueba.venta.entity.Venta;

import java.util.List;

public interface VentaService {

    Venta guardarVenta(Venta venta);
    List<Venta> listarVentas();
    Venta buscarVenta(int idVenta);
}
