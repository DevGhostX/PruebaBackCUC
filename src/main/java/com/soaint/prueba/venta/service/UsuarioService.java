package com.soaint.prueba.venta.service;

import com.soaint.prueba.venta.entity.Usuario;

public interface UsuarioService {

    Usuario findByUsername(String username);
}
