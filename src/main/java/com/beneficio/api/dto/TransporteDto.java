/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.dto;

/**
 *
 * @author BYRON
 */
public class TransporteDto {
    
    private String nombre;
    
    private String apellido;
    
    private Long licencia;
    
    private String placa;
    
    private String usuarioRegistro;

    public TransporteDto() {
    }

    public TransporteDto(Long licencia) {
        this.licencia = licencia;
    }
    
    public TransporteDto(String placa) {
        this.placa = placa;
    }

    public TransporteDto(String nombre, String apellido, Long licencia, String placa, String usuarioRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.placa = placa;
        this.usuarioRegistro = usuarioRegistro;
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
    
    
}
