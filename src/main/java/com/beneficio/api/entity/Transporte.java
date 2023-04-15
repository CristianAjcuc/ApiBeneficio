/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BYRON
 */
@Entity
public class Transporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    
    private String apellido;
    
    @NotNull
    private Long licencia;
    
    private String placa;
    
    private String usuarioRegistro;
    
    private Date fechaRegistro;
    
    private Boolean estado;
    
    @PrePersist
    public void prePersist() {
        this.fechaRegistro = new Date();
        this.estado = true;
    }

    public Transporte() {
    }

    public Transporte(int id) {
        this.id = id;
    }
    
    public Transporte(String placa) {
        this.placa = placa;
    }

    public Transporte(String nombre, String apellido, Long licencia, String placa, String usuarioRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.placa = placa;
        this.usuarioRegistro = usuarioRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getLicencia() {
        return licencia;
    }

    public void setLicencia(Long licencia) {
        this.licencia = licencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
