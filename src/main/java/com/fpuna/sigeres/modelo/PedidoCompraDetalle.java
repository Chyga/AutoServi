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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pedido_compra_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoCompraDetalle.findAll", query = "SELECT p FROM PedidoCompraDetalle p"),
    @NamedQuery(name = "PedidoCompraDetalle.findById", query = "SELECT p FROM PedidoCompraDetalle p WHERE p.id = :id"),
    @NamedQuery(name = "PedidoCompraDetalle.findByCantidad", query = "SELECT p FROM PedidoCompraDetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoCompraDetalle.findByPrecio", query = "SELECT p FROM PedidoCompraDetalle p WHERE p.precio = :precio"),
    @NamedQuery(name = "PedidoCompraDetalle.findByPresentacion", query = "SELECT p FROM PedidoCompraDetalle p WHERE p.presentacion = :presentacion")})
public class PedidoCompraDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presentacion")
    private int presentacion;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Articulos idArticulo;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PedidosCompras idPedido;

    public PedidoCompraDetalle() {
    }

    public PedidoCompraDetalle(Integer id) {
        this.id = id;
    }

    public PedidoCompraDetalle(Integer id, int cantidad, double precio, int presentacion) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.presentacion = presentacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(int presentacion) {
        this.presentacion = presentacion;
    }

    public Articulos getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.idArticulo = idArticulo;
    }

    public PedidosCompras getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(PedidosCompras idPedido) {
        this.idPedido = idPedido;
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
        if (!(object instanceof PedidoCompraDetalle)) {
            return false;
        }
        PedidoCompraDetalle other = (PedidoCompraDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.PedidoCompraDetalle[ id=" + id + " ]";
    }
    
}
