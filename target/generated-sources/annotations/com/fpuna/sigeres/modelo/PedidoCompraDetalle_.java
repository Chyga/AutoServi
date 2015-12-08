package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.PedidosCompras;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(PedidoCompraDetalle.class)
public class PedidoCompraDetalle_ { 

    public static volatile SingularAttribute<PedidoCompraDetalle, Articulos> idArticulo;
    public static volatile SingularAttribute<PedidoCompraDetalle, Double> precio;
    public static volatile SingularAttribute<PedidoCompraDetalle, Integer> presentacion;
    public static volatile SingularAttribute<PedidoCompraDetalle, Integer> id;
    public static volatile SingularAttribute<PedidoCompraDetalle, Integer> cantidad;
    public static volatile SingularAttribute<PedidoCompraDetalle, PedidosCompras> idPedido;

}