/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.dto.ParcialidadDto;
import com.beneficio.api.entity.Parcialidad;
import com.beneficio.api.entity.Transporte;
import com.beneficio.api.security.enums.TransportePlaca;
import com.beneficio.api.service.ParcialidadService;
import com.beneficio.api.service.TransporteService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@RequestMapping("/parcialidad")
@CrossOrigin(origins = "*")
public class ParcialidadController {
    
    @Autowired
    ParcialidadService parcialidadService;
    
    @Autowired
    TransporteService transporteService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Parcialidad>> list(){
        List<Parcialidad> list = parcialidadService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Parcialidad> getById(@PathVariable("id") int id){
        if(!parcialidadService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Parcialidad parcialidad = parcialidadService.getOne(id).get();
        return new ResponseEntity(parcialidad, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ParcialidadDto parcialidadDto){
//        if(productorDtoparcialidadDto.getUsuario()==null)
//            return new ResponseEntity(new Mensaje("el id del productor es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(parcialidadDto.getDpi()<0 || productorDto.getDpi()==null )
//            return new ResponseEntity(new Mensaje("el dpi debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productorService.existsByDpi(parcialidadDto.getDpi()))
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
        Parcialidad parcialidad = new Parcialidad(parcialidadDto.getUsuario_id(), parcialidadDto.getPesoTotal(),parcialidadDto.getCantidadCamion(),parcialidadDto.getFechaEntrega(),parcialidadDto.getUsuarioRegistro());
        
        Set<Transporte> transportes = new HashSet<>();
        
        if(parcialidadDto.getTransportes().contains("PLACA_1"))
            transportes.add(transporteService.getByPlaca(TransportePlaca.PLACA_1.toString()).get());
        if(parcialidadDto.getTransportes().contains("PLACA_2"))
            transportes.add(transporteService.getByPlaca(TransportePlaca.PLACA_2.toString()).get());
        parcialidad.setTransportes(transportes);
        
        parcialidadService.save(parcialidad);
        return new ResponseEntity(new Mensaje("parcialidad creada"), HttpStatus.OK);
    }
}
