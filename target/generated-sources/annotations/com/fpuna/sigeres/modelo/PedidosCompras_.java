package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.PedidoCompraDetalle;
import com.fpuna.sigeres.modelo.Proveedores;
import com.fpuna.sigeres.modelo.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(PedidosCompras.class)
public class PedidosCompras_ { 

    public static volatile SingularAttribute<PedidosCompras, Date> fecha;
    public static volatile SingularAttribute<PedidosCompras, String> estado;
    public static volatile ListAttribute<PedidosCompras, PedidoCompraDetalle> pedidoCompraDetalleList;
    public static volatile SingularAttribute<PedidosCompras, Proveedores> idProveedor;
    public static volatile SingularAttribute<PedidosCompras, Usuarios> idUsuario;
    public static volatile SingularAttribute<PedidosCompras, Date> fechaEntrega;
    public static volatile SingularAttribute<PedidosCompras, Integer> id;

}