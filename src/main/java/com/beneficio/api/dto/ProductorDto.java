/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.dto;

import com.beneficio.api.security.entity.Usuario;
import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BYRON
 */
public class ProductorDto {
    
    @NotNull
    private Usuario usuario;
    
    @NotNull
    private Long dpi;
    
    private String direccion;
    
    //private Date fechaRegistro;
    
    private String usuarioRegistro;
    
    //private Boolean estado;

    public ProductorDto() {
    }
        
    public ProductorDto(Long dpi){
        this.dpi = dpi;
    }
    
    public ProductorDto(@NotBlank Usuario usuario, @NotBlank Long dpi, String direccion, Date fechaRegistro, String usuarioRegistro) {
        this.usuario = usuario;
        this.dpi = dpi;
        this.direccion = direccion;
        //this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getDpi() {
        return dpi;
    }

    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//    public Date getFechaRegistro() {
//        return fechaRegistro;
//    }
//
//    public void setFechaRegistro(Date fechaRegistro) {
//        this.fechaRegistro = fechaRegistro;
//    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

//    public Boolean getEstado() {
//        return estado;
//    }
//
//    public void setEstado(Boolean estado) {
//        this.estado = estado;
//    }

}
