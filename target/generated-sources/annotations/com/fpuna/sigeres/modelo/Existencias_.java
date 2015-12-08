package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.Depositos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Existencias.class)
public class Existencias_ { 

    public static volatile SingularAttribute<Existencias, Articulos> idArticulo;
    public static volatile SingularAttribute<Existencias, String> fila;
    public static volatile SingularAttribute<Existencias, Integer> id;
    public static volatile SingularAttribute<Existencias, Double> cantidad;
    public static volatile SingularAttribute<Existencias, String> codigoidentificador;
    public static volatile SingularAttribute<Existencias, Depositos> idDeposito;
    public static volatile SingularAttribute<Existencias, String> bloque;
    public static volatile SingularAttribute<Existencias, String> sector;

}