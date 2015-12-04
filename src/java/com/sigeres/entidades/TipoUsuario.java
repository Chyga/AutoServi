
package com.sigeres.entidades;

public class TipoUsuario {
   private int id_tipousuario;
   private String codigo;
   private String descripcion;
   private int chkventa;
   private int chkcompra;
   private int chkusuario;
   private int chkcaja;
   private int chkfactura;
   private int chkinventario;
   private String estado;

    public int getChkventa() {
        return chkventa;
    }

    public void setChkventa(int chkventa) {
        this.chkventa = chkventa;
    }

    public int getChkcompra() {
        return chkcompra;
    }

    public void setChkcompra(int chkcompra) {
        this.chkcompra = chkcompra;
    }

    public int getChkusuario() {
        return chkusuario;
    }

    public void setChkusuario(int chkusuario) {
        this.chkusuario = chkusuario;
    }

    public int getChkcaja() {
        return chkcaja;
    }

    public void setChkcaja(int chkcaja) {
        this.chkcaja = chkcaja;
    }

    public int getChkfactura() {
        return chkfactura;
    }

    public void setChkfactura(int chkfactura) {
        this.chkfactura = chkfactura;
    }

    public int getChkinventario() {
        return chkinventario;
    }

    public void setChkinventario(int chkinventario) {
        this.chkinventario = chkinventario;
    }

   
    public int getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
        
}
