package com.beneficio.api.security.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.entity.RandomCharGenerator;
import com.beneficio.api.security.dto.JwtDto;
import com.beneficio.api.security.dto.LoginUsuario;
import com.beneficio.api.security.dto.NuevoUsuario;
import com.beneficio.api.security.entity.Rol;
import com.beneficio.api.security.entity.Usuario;
import com.beneficio.api.security.enums.RolNombre;
import com.beneficio.api.security.jwt.JwtProvider;
import com.beneficio.api.security.service.RolService;
import com.beneficio.api.security.service.UsuarioService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        
        RandomCharGenerator generar = new RandomCharGenerator();
        
        String usuarioG = generar.generateUsuario(); 
        String contrasenia = generar.generateRandomPassword(10);
        
        Map<String, Object> response = new HashMap<>();
        
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
//        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuario.getDpi(), nuevoUsuario.getNombre(), nuevoUsuario.getApellido(), nuevoUsuario.getDireccion(), nuevoUsuario.getEmail(), nuevoUsuario.getTelefono(), usuarioG,
                        passwordEncoder.encode(contrasenia));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_PRODUCTOR).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        if(nuevoUsuario.getRoles().contains("user"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        response.put("mensaje","Usuario guardado.");
        response.put("cuenta", usuarioG);
        response.put("contraseña", contrasenia);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        //return new ResponseEntity(new Mensaje("usuario guardado. La contraseña es: ".concat(contrasenia).concat(" y el usuario es: ".concat(Long.toString(nuevoUsuario.getDpi())))), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
