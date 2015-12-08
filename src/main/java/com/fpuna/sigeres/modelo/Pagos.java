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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findById", query = "SELECT p FROM Pagos p WHERE p.id = :id"),
    @NamedQuery(name = "Pagos.findByMonto", query = "SELECT p FROM Pagos p WHERE p.monto = :monto"),
    @NamedQuery(name = "Pagos.findByMotivo", query = "SELECT p FROM Pagos p WHERE p.motivo = :motivo"),
    @NamedQuery(name = "Pagos.findByTransaccion", query = "SELECT p FROM Pagos p WHERE p.transaccion = :transaccion"),
    @NamedQuery(name = "Pagos.findByIdTipoTransaccion", query = "SELECT p FROM Pagos p WHERE p.idTipoTransaccion = :idTipoTransaccion"),
    @NamedQuery(name = "Pagos.findByEstado", query = "SELECT p FROM Pagos p WHERE p.estado = :estado")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private double monto;
    @Size(max = 100)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transaccion")
    private String transaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_TipoTransaccion")
    private int idTipoTransaccion;
    @Size(max = 100)
    @Column(name = "estado")
    private String estado;

    public Pagos() {
    }

    public Pagos(Integer id) {
        this.id = id;
    }

    public Pagos(Integer id, double monto, String transaccion, int idTipoTransaccion) {
        this.id = id;
        this.monto = monto;
        this.transaccion = transaccion;
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public int getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.Pagos[ id=" + id + " ]";
    }
    
}
