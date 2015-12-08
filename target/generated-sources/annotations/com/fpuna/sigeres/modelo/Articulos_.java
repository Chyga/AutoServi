package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Existencias;
import com.fpuna.sigeres.modelo.Grupos;
import com.fpuna.sigeres.modelo.Marcas;
import com.fpuna.sigeres.modelo.PedidoCompraDetalle;
import com.fpuna.sigeres.modelo.Proveedores;
import com.fpuna.sigeres.modelo.SubGrupos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile ListAttribute<Articulos, Existencias> existenciasList;
    public static volatile SingularAttribute<Articulos, String> estado;
    public static volatile SingularAttribute<Articulos, String> codigo;
    public static volatile SingularAttribute<Articulos, Double> medida1;
    public static volatile SingularAttribute<Articulos, Double> preciobase;
    public static volatile SingularAttribute<Articulos, String> unidadmedida4;
    public static volatile SingularAttribute<Articulos, Double> medida4;
    public static volatile SingularAttribute<Articulos, String> unidadmedida3;
    public static volatile SingularAttribute<Articulos, String> aplicacion;
    public static volatile SingularAttribute<Articulos, byte[]> imagen;
    public static volatile SingularAttribute<Articulos, Double> medida3;
    public static volatile SingularAttribute<Articulos, String> unidadmedida2;
    public static volatile SingularAttribute<Articulos, Double> preciocompra;
    public static volatile SingularAttribute<Articulos, Double> medida2;
    public static volatile SingularAttribute<Articulos, String> unidadmedida1;
    public static volatile SingularAttribute<Articulos, Double> impuesto;
    public static volatile SingularAttribute<Articulos, SubGrupos> idSubgrupo;
    public static volatile ListAttribute<Articulos, PedidoCompraDetalle> pedidoCompraDetalleList;
    public static volatile SingularAttribute<Articulos, Proveedores> idProveedor;
    public static volatile SingularAttribute<Articulos, String> codigobarra;
    public static volatile SingularAttribute<Articulos, Integer> id;
    public static volatile SingularAttribute<Articulos, Marcas> idMarca;
    public static volatile SingularAttribute<Articulos, Grupos> idGrupo;

}