package com.soaint.prueba.venta.service.impl;

import com.soaint.prueba.venta.entity.Cliente;
import com.soaint.prueba.venta.repository.ClienteRepository;
import com.soaint.prueba.venta.service.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
