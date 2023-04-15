/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.entity.Transporte;
import com.beneficio.api.dto.TransporteDto;
import com.beneficio.api.service.TransporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BYRON
 */
@RestController
@RequestMapping("/transporte")
@CrossOrigin(origins = "*")
public class TransporteController {
    
    @Autowired
    TransporteService transporteService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Transporte>> list(){
        List<Transporte> list = transporteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Transporte> getById(@PathVariable("id") int id){
        if(!transporteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Transporte transporte = transporteService.getOne(id).get();
        return new ResponseEntity(transporte, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> create(@RequestBody TransporteDto transporteDto){
//        if(productorDtoparcialidadDto.getUsuario()==null)
//            return new ResponseEntity(new Mensaje("el id del productor es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(parcialidadDto.getDpi()<0 || productorDto.getDpi()==null )
//            return new ResponseEntity(new Mensaje("el dpi debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productorService.existsByDpi(parcialidadDto.getDpi()))
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
        Transporte transporte = new Transporte(transporteDto.getNombre(), transporteDto.getApellido(), transporteDto.getLicencia(),transporteDto.getPlaca(),transporteDto.getUsuarioRegistro());
        transporteService.save(transporte);
        return new ResponseEntity(new Mensaje("transporte creado"), HttpStatus.OK);
    }
}
