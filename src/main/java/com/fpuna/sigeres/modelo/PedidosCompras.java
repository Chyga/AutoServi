/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pedidos_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosCompras.findAll", query = "SELECT p FROM PedidosCompras p"),
    @NamedQuery(name = "PedidosCompras.findById", query = "SELECT p FROM PedidosCompras p WHERE p.id = :id"),
    @NamedQuery(name = "PedidosCompras.findByEstado", query = "SELECT p FROM PedidosCompras p WHERE p.estado = :estado"),
    @NamedQuery(name = "PedidosCompras.findByFecha", query = "SELECT p FROM PedidosCompras p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PedidosCompras.findByFechaEntrega", query = "SELECT p FROM PedidosCompras p WHERE p.fechaEntrega = :fechaEntrega")})
public class PedidosCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proveedores idProveedor;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido", fetch = FetchType.EAGER)
    private List<PedidoCompraDetalle> pedidoCompraDetalleList;

    public PedidosCompras() {
    }

    public PedidosCompras(Integer id) {
        this.id = id;
    }

    public PedidosCompras(Integer id, String estado, Date fecha, Date fechaEntrega) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<PedidoCompraDetalle> getPedidoCompraDetalleList() {
        return pedidoCompraDetalleList;
    }

    public void setPedidoCompraDetalleList(List<PedidoCompraDetalle> pedidoCompraDetalleList) {
        this.pedidoCompraDetalleList = pedidoCompraDetalleList;
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
        if (!(object instanceof PedidosCompras)) {
            return false;
        }
        PedidosCompras other = (PedidosCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.PedidosCompras[ id=" + id + " ]";
    }
    
}
