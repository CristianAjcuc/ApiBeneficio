/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.dto;

import com.beneficio.api.security.entity.Usuario;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BYRON
 */
public class ParcialidadDto {
        
    private Usuario usuario_id;
    
    private Double pesoTotal;
    
    private int cantidadCamion;
    
    private Date fechaEntrega;
    
    private String usuarioRegistro;
        
    private Set<String> transportes = new HashSet<>();

    public ParcialidadDto() {
    }

    public ParcialidadDto(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    public ParcialidadDto(Usuario usuario_id, Double pesoTotal, int cantidadCamion, Date fechaEntrega, String usuarioRegistro) {
        this.usuario_id = usuario_id;
        this.pesoTotal = pesoTotal;
        this.cantidadCamion = cantidadCamion;
        this.fechaEntrega = fechaEntrega;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public int getCantidadCamion() {
        return cantidadCamion;
    }

    public void setCantidadCamion(int cantidadCamion) {
        this.cantidadCamion = cantidadCamion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Set<String> getTransportes() {
        return transportes;
    }

    public void setTransportes(Set<String> transportes) {
        this.transportes = transportes;
    }
    
    
}
