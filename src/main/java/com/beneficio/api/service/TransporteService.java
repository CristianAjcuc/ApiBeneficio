/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.service;

import com.beneficio.api.entity.Transporte;
import com.beneficio.api.repository.TransporteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BYRON
 */
@Service
@Transactional
public class TransporteService {
    
    @Autowired
    TransporteRepository transporteRepository;

    public List<Transporte> list(){
        return transporteRepository.findAll();
    }

    public Optional<Transporte> getOne(int id){
        return transporteRepository.findById(id);
    }

    public Optional<Transporte> getByLicencia(Long id){
        return transporteRepository.findByLicencia(id);
    }
    
    public Optional<Transporte> getByPlaca(String id){
        return transporteRepository.findByPlaca(id);
    }

    public void  save(Transporte transporte){
        transporteRepository.save(transporte);
    }

    public void delete(int id){
        transporteRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return transporteRepository.existsById(id);
    }

    public boolean existsByLicencia(Long id){
        return transporteRepository.existsByLicencia(id);
    }
}
