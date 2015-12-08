package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.PedidosCompras;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, Integer> idDepartamento;
    public static volatile SingularAttribute<Proveedores, String> codigo;
    public static volatile SingularAttribute<Proveedores, String> estado;
    public static volatile ListAttribute<Proveedores, Articulos> articulosList;
    public static volatile SingularAttribute<Proveedores, String> razonsocial;
    public static volatile SingularAttribute<Proveedores, String> celular;
    public static volatile ListAttribute<Proveedores, PedidosCompras> pedidosComprasList;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, Integer> idCiudad;

}