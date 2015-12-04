package com.sigeres.entidades;

public class Usuario {
   private int id_usuario;
   private String codigo;
   private String clave;
   private String nombre;
   private String apellido;
   private int id_tipousuario;
   private String destipousuario;
   private String estado;

    public String getDestipousuario() {
        return destipousuario;
    }

    public void setDestipousuario(String destipousuario) {
        this.destipousuario = destipousuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getCodigo() {
         return codigo;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId_tipousuario() {
        return id_tipousuario;
    }
}
