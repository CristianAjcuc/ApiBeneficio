/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.api.repository;

import com.beneficio.api.entity.Transporte;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BYRON
 */
public interface TransporteRepository extends JpaRepository<Transporte, Integer>{
    
    Optional<Transporte> findByLicencia(Long licencia);
    
    Optional<Transporte> findByPlaca(String placa);
    
    boolean existsByLicencia(Long licencia);
}
