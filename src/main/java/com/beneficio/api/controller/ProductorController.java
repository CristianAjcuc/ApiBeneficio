/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import com.beneficio.api.dto.Mensaje;
import com.beneficio.api.dto.ProductorDto;
import com.beneficio.api.entity.Productor;
import com.beneficio.api.service.ProductorService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BYRON
 */
//@RestController
//@RequestMapping("/productor")
//@CrossOrigin(origins = "*")
public class ProductorController {
    
//    @Autowired
//    ProductorService productorService;
//
//    @GetMapping("/lista")
//    public ResponseEntity<List<Productor>> list(){
//        List<Productor> list = productorService.list();
//        return new ResponseEntity(list, HttpStatus.OK);
//    }
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity<Productor> getById(@PathVariable("id") int id){
//        if(!productorService.existsById(id))
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        Productor productor = productorService.getOne(id).get();
//        return new ResponseEntity(productor, HttpStatus.OK);
//    }
//
//    @GetMapping("/dpi/{dpi}")
//    public ResponseEntity<Productor> getByDpi(@PathVariable("dpi") Long dpi){
//        if(!productorService.existsByDpi(dpi))
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        Productor productor = productorService.getByDpi(dpi).get();
//        return new ResponseEntity(productor, HttpStatus.OK);
//    }
//
//    //@PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/inscripcion")
//    public ResponseEntity<?> create(@RequestBody ProductorDto productorDto){
//        if(productorDto.getUsuario()==null)
//            return new ResponseEntity(new Mensaje("el id del productor es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productorDto.getDpi()<0 || productorDto.getDpi()==null )
//            return new ResponseEntity(new Mensaje("el dpi debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//        if(productorService.existsByDpi(productorDto.getDpi()))
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
//        Productor productor = new Productor(productorDto.getUsuario(), productorDto.getDpi(),productorDto.getDireccion(),productorDto.getUsuarioRegistro());
//        productorService.save(productor);
//        return new ResponseEntity(new Mensaje("productor creado"), HttpStatus.OK);
//    }
//
//    //@PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/actualizar/{id}")
//    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductorDto productorDto){
//        if(!productorService.existsById(id))
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        if(productorService.existsByDpi(productorDto.getDpi()) && productorService.getByDpi(productorDto.getDpi()).get().getId() != id)
//            return new ResponseEntity(new Mensaje("ese dpi ya existe"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(productorDto.getDireccion()))
//            return new ResponseEntity(new Mensaje("la direccion es obligatoria"), HttpStatus.BAD_REQUEST);
////        if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
////            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
//
//        Productor productor = productorService.getOne(id).get();
//        productor.setUsuario(productorDto.getUsuario());
//        productor.setDpi(productorDto.getDpi());
//        productor.setDireccion(productorDto.getDireccion());
//        productor.setUsuarioRegistro(productorDto.getUsuarioRegistro());
//        
//        productorService.save(productor);
//        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id")int id){
//        if(!productorService.existsById(id))
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        productorService.delete(id);
//        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
//    }
}
