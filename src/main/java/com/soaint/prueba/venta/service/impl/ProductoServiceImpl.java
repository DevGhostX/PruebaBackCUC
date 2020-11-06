package com.soaint.prueba.venta.service.impl;

import com.soaint.prueba.venta.entity.Producto;
import com.soaint.prueba.venta.repository.ProductoRepository;
import com.soaint.prueba.venta.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void eliminarProducto(int idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarProducto(int idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }
}
