package com.beneficio.api.security.service;

import com.beneficio.api.security.entity.Usuario;
import com.beneficio.api.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
//    @Override
//    public UserDetails loadUserByDpi(String dpi) throws UsernameNotFoundException {
//        Usuario usuario = usuarioService.getByDpi(dpi).get();
//        return UsuarioPrincipal.build(usuario);
//    }
}
