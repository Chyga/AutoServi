/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findById", query = "SELECT a FROM Articulos a WHERE a.id = :id"),
    @NamedQuery(name = "Articulos.findByCodigo", query = "SELECT a FROM Articulos a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Articulos.findByCodigobarra", query = "SELECT a FROM Articulos a WHERE a.codigobarra = :codigobarra"),
    @NamedQuery(name = "Articulos.findByDescripcion", query = "SELECT a FROM Articulos a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Articulos.findByImpuesto", query = "SELECT a FROM Articulos a WHERE a.impuesto = :impuesto"),
    @NamedQuery(name = "Articulos.findByPreciocompra", query = "SELECT a FROM Articulos a WHERE a.preciocompra = :preciocompra"),
    @NamedQuery(name = "Articulos.findByPreciobase", query = "SELECT a FROM Articulos a WHERE a.preciobase = :preciobase"),
    @NamedQuery(name = "Articulos.findByMedida1", query = "SELECT a FROM Articulos a WHERE a.medida1 = :medida1"),
    @NamedQuery(name = "Articulos.findByMedida2", query = "SELECT a FROM Articulos a WHERE a.medida2 = :medida2"),
    @NamedQuery(name = "Articulos.findByMedida3", query = "SELECT a FROM Articulos a WHERE a.medida3 = :medida3"),
    @NamedQuery(name = "Articulos.findByMedida4", query = "SELECT a FROM Articulos a WHERE a.medida4 = :medida4"),
    @NamedQuery(name = "Articulos.findByUnidadmedida1", query = "SELECT a FROM Articulos a WHERE a.unidadmedida1 = :unidadmedida1"),
    @NamedQuery(name = "Articulos.findByUnidadmedida2", query = "SELECT a FROM Articulos a WHERE a.unidadmedida2 = :unidadmedida2"),
    @NamedQuery(name = "Articulos.findByUnidadmedida3", query = "SELECT a FROM Articulos a WHERE a.unidadmedida3 = :unidadmedida3"),
    @NamedQuery(name = "Articulos.findByUnidadmedida4", query = "SELECT a FROM Articulos a WHERE a.unidadmedida4 = :unidadmedida4"),
    @NamedQuery(name = "Articulos.findByAplicacion", query = "SELECT a FROM Articulos a WHERE a.aplicacion = :aplicacion"),
    @NamedQuery(name = "Articulos.findByEstado", query = "SELECT a FROM Articulos a WHERE a.estado = :estado")})
public class Articulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 25)
    @Column(name = "codigobarra")
    private String codigobarra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private double impuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciocompra")
    private double preciocompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciobase")
    private double preciobase;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "medida1")
    private Double medida1;
    @Column(name = "medida2")
    private Double medida2;
    @Column(name = "medida3")
    private Double medida3;
    @Column(name = "medida4")
    private Double medida4;
    @Size(max = 20)
    @Column(name = "unidadmedida1")
    private String unidadmedida1;
    @Size(max = 20)
    @Column(name = "unidadmedida2")
    private String unidadmedida2;
    @Size(max = 20)
    @Column(name = "unidadmedida3")
    private String unidadmedida3;
    @Size(max = 20)
    @Column(name = "unidadmedida4")
    private String unidadmedida4;
    @Size(max = 100)
    @Column(name = "aplicacion")
    private String aplicacion;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_marca", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Marcas idMarca;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proveedores idProveedor;
    @JoinColumn(name = "id_subgrupo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SubGrupos idSubgrupo;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Grupos idGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo", fetch = FetchType.EAGER)
    private List<PedidoCompraDetalle> pedidoCompraDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticulo", fetch = FetchType.EAGER)
    private List<Existencias> existenciasList;

    public Articulos() {
    }

    public Articulos(Integer id) {
        this.id = id;
    }

    public Articulos(Integer id, String codigo, String descripcion, double impuesto, double preciocompra, double preciobase, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.impuesto = impuesto;
        this.preciocompra = preciocompra;
        this.preciobase = preciobase;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPreciobase() {
        return preciobase;
    }

    public void setPreciobase(double preciobase) {
        this.preciobase = preciobase;
    }

    public Double getMedida1() {
        return medida1;
    }

    public void setMedida1(Double medida1) {
        this.medida1 = medida1;
    }

    public Double getMedida2() {
        return medida2;
    }

    public void setMedida2(Double medida2) {
        this.medida2 = medida2;
    }

    public Double getMedida3() {
        return medida3;
    }

    public void setMedida3(Double medida3) {
        this.medida3 = medida3;
    }

    public Double getMedida4() {
        return medida4;
    }

    public void setMedida4(Double medida4) {
        this.medida4 = medida4;
    }

    public String getUnidadmedida1() {
        return unidadmedida1;
    }

    public void setUnidadmedida1(String unidadmedida1) {
        this.unidadmedida1 = unidadmedida1;
    }

    public String getUnidadmedida2() {
        return unidadmedida2;
    }

    public void setUnidadmedida2(String unidadmedida2) {
        this.unidadmedida2 = unidadmedida2;
    }

    public String getUnidadmedida3() {
        return unidadmedida3;
    }

    public void setUnidadmedida3(String unidadmedida3) {
        this.unidadmedida3 = unidadmedida3;
    }

    public String getUnidadmedida4() {
        return unidadmedida4;
    }

    public void setUnidadmedida4(String unidadmedida4) {
        this.unidadmedida4 = unidadmedida4;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public SubGrupos getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(SubGrupos idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    @XmlTransient
    public List<PedidoCompraDetalle> getPedidoCompraDetalleList() {
        return pedidoCompraDetalleList;
    }

    public void setPedidoCompraDetalleList(List<PedidoCompraDetalle> pedidoCompraDetalleList) {
        this.pedidoCompraDetalleList = pedidoCompraDetalleList;
    }

    @XmlTransient
    public List<Existencias> getExistenciasList() {
        return existenciasList;
    }

    public void setExistenciasList(List<Existencias> existenciasList) {
        this.existenciasList = existenciasList;
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
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.Articulos[ id=" + id + " ]";
    }
    
}
