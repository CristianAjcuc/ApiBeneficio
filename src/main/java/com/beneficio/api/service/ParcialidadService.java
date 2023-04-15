/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.service;

import com.beneficio.api.entity.Parcialidad;
import com.beneficio.api.repository.ParcialidadRepository;
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
public class ParcialidadService {
    
    @Autowired
    ParcialidadRepository parcialidadRepository;

    public List<Parcialidad> list(){
        return parcialidadRepository.findAll();
    }

    public Optional<Parcialidad> getOne(int id){
        return parcialidadRepository.findById(id);
    }

//    public Optional<Parcialidad> getByProductorId(int id){
//        return parcialidadRepository.findByProductorId(id);
//    }

    public void  save(Parcialidad parcialidad){
        parcialidadRepository.save(parcialidad);
    }

    public void delete(int id){
        parcialidadRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return parcialidadRepository.existsById(id);
    }

//    public boolean existsByProductorId(int id){
//        return parcialidadRepository.existsByProductorId(id);
//    }
}
