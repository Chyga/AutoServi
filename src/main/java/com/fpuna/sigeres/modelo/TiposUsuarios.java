/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tipos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposUsuarios.findAll", query = "SELECT t FROM TiposUsuarios t"),
    @NamedQuery(name = "TiposUsuarios.findById", query = "SELECT t FROM TiposUsuarios t WHERE t.id = :id"),
    @NamedQuery(name = "TiposUsuarios.findByIdPermiso", query = "SELECT t FROM TiposUsuarios t WHERE t.idPermiso = :idPermiso"),
    @NamedQuery(name = "TiposUsuarios.findByCodigo", query = "SELECT t FROM TiposUsuarios t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TiposUsuarios.findByDescripcion", query = "SELECT t FROM TiposUsuarios t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposUsuarios.findByChkinventario", query = "SELECT t FROM TiposUsuarios t WHERE t.chkinventario = :chkinventario"),
    @NamedQuery(name = "TiposUsuarios.findByChkfacturacion", query = "SELECT t FROM TiposUsuarios t WHERE t.chkfacturacion = :chkfacturacion"),
    @NamedQuery(name = "TiposUsuarios.findByChkcaja", query = "SELECT t FROM TiposUsuarios t WHERE t.chkcaja = :chkcaja"),
    @NamedQuery(name = "TiposUsuarios.findByChkcompra", query = "SELECT t FROM TiposUsuarios t WHERE t.chkcompra = :chkcompra"),
    @NamedQuery(name = "TiposUsuarios.findByChkseguridad", query = "SELECT t FROM TiposUsuarios t WHERE t.chkseguridad = :chkseguridad"),
    @NamedQuery(name = "TiposUsuarios.findByChkventa", query = "SELECT t FROM TiposUsuarios t WHERE t.chkventa = :chkventa"),
    @NamedQuery(name = "TiposUsuarios.findByEstado", query = "SELECT t FROM TiposUsuarios t WHERE t.estado = :estado")})
public class TiposUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_permiso")
    private int idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkinventario")
    private int chkinventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkfacturacion")
    private int chkfacturacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkcaja")
    private int chkcaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkcompra")
    private int chkcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkseguridad")
    private int chkseguridad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chkventa")
    private int chkventa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idTipousuario", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    public TiposUsuarios() {
    }

    public TiposUsuarios(Integer id) {
        this.id = id;
    }

    public TiposUsuarios(Integer id, int idPermiso, String codigo, String descripcion, int chkinventario, int chkfacturacion, int chkcaja, int chkcompra, int chkseguridad, int chkventa, String estado) {
        this.id = id;
        this.idPermiso = idPermiso;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.chkinventario = chkinventario;
        this.chkfacturacion = chkfacturacion;
        this.chkcaja = chkcaja;
        this.chkcompra = chkcompra;
        this.chkseguridad = chkseguridad;
        this.chkventa = chkventa;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
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

    public int getChkinventario() {
        return chkinventario;
    }

    public void setChkinventario(int chkinventario) {
        this.chkinventario = chkinventario;
    }

    public int getChkfacturacion() {
        return chkfacturacion;
    }

    public void setChkfacturacion(int chkfacturacion) {
        this.chkfacturacion = chkfacturacion;
    }

    public int getChkcaja() {
        return chkcaja;
    }

    public void setChkcaja(int chkcaja) {
        this.chkcaja = chkcaja;
    }

    public int getChkcompra() {
        return chkcompra;
    }

    public void setChkcompra(int chkcompra) {
        this.chkcompra = chkcompra;
    }

    public int getChkseguridad() {
        return chkseguridad;
    }

    public void setChkseguridad(int chkseguridad) {
        this.chkseguridad = chkseguridad;
    }

    public int getChkventa() {
        return chkventa;
    }

    public void setChkventa(int chkventa) {
        this.chkventa = chkventa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposUsuarios)) {
            return false;
        }
        TiposUsuarios other = (TiposUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.TiposUsuarios[ id=" + id + " ]";
    }
    
}
