/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.api.repository;

import com.beneficio.api.entity.Parcialidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BYRON
 */
public interface ParcialidadRepository extends JpaRepository<Parcialidad, Integer>{
    
//    Optional<Parcialidad> findByProductorId(int productor_id);
    
//    boolean existsByProductorId(int productor_id);
}
