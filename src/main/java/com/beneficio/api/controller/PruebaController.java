/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BYRON
 */

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = "*")
public class PruebaController {
    
    @GetMapping("/prueba")
     public ResponseEntity<?> obtenerFechaActual() {
         
        Map<String, Object> response = new HashMap<>();
        
        response.put("fechaActual", LocalDateTime.now());
        response.put("mensaje", "El servicio web está funcionando correctamente");
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        //return LocalDateTime.now();
    }
    
}
