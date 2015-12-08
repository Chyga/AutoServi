/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "existencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Existencias.findAll", query = "SELECT e FROM Existencias e"),
    @NamedQuery(name = "Existencias.findById", query = "SELECT e FROM Existencias e WHERE e.id = :id"),
    @NamedQuery(name = "Existencias.findByCantidad", query = "SELECT e FROM Existencias e WHERE e.cantidad = :cantidad"),
    @NamedQuery(name = "Existencias.findByBloque", query = "SELECT e FROM Existencias e WHERE e.bloque = :bloque"),
    @NamedQuery(name = "Existencias.findBySector", query = "SELECT e FROM Existencias e WHERE e.sector = :sector"),
    @NamedQuery(name = "Existencias.findByFila", query = "SELECT e FROM Existencias e WHERE e.fila = :fila"),
    @NamedQuery(name = "Existencias.findByCodigoidentificador", query = "SELECT e FROM Existencias e WHERE e.codigoidentificador = :codigoidentificador")})
public class Existencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Size(max = 20)
    @Column(name = "bloque")
    private String bloque;
    @Size(max = 20)
    @Column(name = "sector")
    private String sector;
    @Size(max = 20)
    @Column(name = "fila")
    private String fila;
    @Size(max = 20)
    @Column(name = "codigoidentificador")
    private String codigoidentificador;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Articulos idArticulo;
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Depositos idDeposito;

    public Existencias() {
    }

    public Existencias(Integer id) {
        this.id = id;
    }

    public Existencias(Integer id, double cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getCodigoidentificador() {
        return codigoidentificador;
    }

    public void setCodigoidentificador(String codigoidentificador) {
        this.codigoidentificador = codigoidentificador;
    }

    public Articulos getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Depositos getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Depositos idDeposito) {
        this.idDeposito = idDeposito;
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
        if (!(object instanceof Existencias)) {
            return false;
        }
        Existencias other = (Existencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.Existencias[ id=" + id + " ]";
    }
    
}
