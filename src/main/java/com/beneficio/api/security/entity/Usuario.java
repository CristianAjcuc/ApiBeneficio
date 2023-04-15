package com.beneficio.api.security.entity;

//import com.beneficio.api.entity.Productor;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(name = "myGenerator", strategy = "com.beneficio.api.entity.CustomIdGenerator")
    private int id;
    
    @NotNull
    private Long dpi;
    
    @NotNull
    private String nombre;
    
    private String apellido;
    
    private String direccion;
    
    @NotNull
    private String email;
    
    private String telefono;
    
    //@NotNull
    @Column(unique = true)
    private String nombreUsuario;
    
    @NotNull
    private String password;
        
//    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Productor productor;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    private Date fechaRegistro;
    
    private Boolean estado;
    
    @PrePersist
    public void prePersist() {
        this.fechaRegistro = new Date();
        this.estado = true;
    }

    public Usuario() {
    }
    
    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(@NotNull Long dpi, @NotNull String nombre, String apellido, String direccion, @NotNull String email, String telefono, String nombreUsuario, @NotNull String password) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        //this.nombreUsuario = Integer.toString(this.id);
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDpi() {
        return dpi;
    }

    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
