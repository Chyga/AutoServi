/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "factura_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCompra.findAll", query = "SELECT f FROM FacturaCompra f"),
    @NamedQuery(name = "FacturaCompra.findById", query = "SELECT f FROM FacturaCompra f WHERE f.id = :id"),
    @NamedQuery(name = "FacturaCompra.findByNumeroFactura", query = "SELECT f FROM FacturaCompra f WHERE f.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "FacturaCompra.findByFecha", query = "SELECT f FROM FacturaCompra f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "FacturaCompra.findByFechaFactura", query = "SELECT f FROM FacturaCompra f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "FacturaCompra.findByTotal", query = "SELECT f FROM FacturaCompra f WHERE f.total = :total"),
    @NamedQuery(name = "FacturaCompra.findBySaldo", query = "SELECT f FROM FacturaCompra f WHERE f.saldo = :saldo"),
    @NamedQuery(name = "FacturaCompra.findByEstado", query = "SELECT f FROM FacturaCompra f WHERE f.estado = :estado"),
    @NamedQuery(name = "FacturaCompra.findByTimbrado", query = "SELECT f FROM FacturaCompra f WHERE f.timbrado = :timbrado")})
public class FacturaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "timbrado")
    private String timbrado;

    public FacturaCompra() {
    }

    public FacturaCompra(Integer id) {
        this.id = id;
    }

    public FacturaCompra(Integer id, Date fecha, Date fechaFactura, double total, double saldo, String estado, String timbrado) {
        this.id = id;
        this.fecha = fecha;
        this.fechaFactura = fechaFactura;
        this.total = total;
        this.saldo = saldo;
        this.estado = estado;
        this.timbrado = timbrado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
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
        if (!(object instanceof FacturaCompra)) {
            return false;
        }
        FacturaCompra other = (FacturaCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.FacturaCompra[ id=" + id + " ]";
    }
    
}
