package com.soaint.prueba.venta.service.impl;

import com.soaint.prueba.venta.entity.Usuario;
import com.soaint.prueba.venta.repository.UsuarioRepository;
import com.soaint.prueba.venta.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioServiceImpl.class);

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            LOGGER.error("Error, no existe el usuario '" + username + "' en el sistema");
            throw new UsernameNotFoundException("Error, no existe el usuario '" + username + "' en el sistema");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
