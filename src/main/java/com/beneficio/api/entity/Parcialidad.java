/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.entity;

import com.beneficio.api.security.entity.Usuario;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BYRON
 */
@Entity
public class Parcialidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //private int productor_id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @NotNull
    private Double pesoTotal;
    
    private int cantidadCamion;
    
    private Date fechaEntrega;
    
    private String usuarioRegistro;
    
    private Date fechaRegistro;
    
    private Boolean estado;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parcialidad_transporte", joinColumns = @JoinColumn(name = "parcialidad_id"),
    inverseJoinColumns = @JoinColumn(name = "transporte_id"))
    private Set<Transporte> transportes = new HashSet<>();
    
    @PrePersist
    public void prePersist() {
        this.fechaRegistro = new Date();
        this.estado = true;
    }

    public Parcialidad() {
    }

    public Parcialidad(int id) {
        this.id = id;
    }

    public Parcialidad(Usuario usuario_id, Double pesoTotal, int cantidadCamion, Date fechaEntrega, String usuarioRegistro) {
        this.usuario = usuario_id;
        this.pesoTotal = pesoTotal;
        this.cantidadCamion = cantidadCamion;
        this.fechaEntrega = fechaEntrega;
        this.usuarioRegistro = usuarioRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getProductor_id() {
        return usuario;
    }

    public void setProductor_id(Usuario usuario_id) {
        this.usuario = usuario_id;
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

    public Set<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(Set<Transporte> transportes) {
        this.transportes = transportes;
    }
    
    
}
