package com.soaint.prueba.venta.service.impl;

import com.soaint.prueba.venta.entity.Venta;
import com.soaint.prueba.venta.repository.VentaRepository;
import com.soaint.prueba.venta.service.VentaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    @Transactional
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Venta buscarVenta(int idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }
}
