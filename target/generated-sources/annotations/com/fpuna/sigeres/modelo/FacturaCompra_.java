package com.fpuna.sigeres.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(FacturaCompra.class)
public class FacturaCompra_ { 

    public static volatile SingularAttribute<FacturaCompra, Date> fecha;
    public static volatile SingularAttribute<FacturaCompra, Double> total;
    public static volatile SingularAttribute<FacturaCompra, String> estado;
    public static volatile SingularAttribute<FacturaCompra, String> timbrado;
    public static volatile SingularAttribute<FacturaCompra, Date> fechaFactura;
    public static volatile SingularAttribute<FacturaCompra, String> numeroFactura;
    public static volatile SingularAttribute<FacturaCompra, Integer> id;
    public static volatile SingularAttribute<FacturaCompra, Double> saldo;

}