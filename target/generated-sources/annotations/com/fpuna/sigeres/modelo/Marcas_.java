package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Marcas.class)
public class Marcas_ { 

    public static volatile SingularAttribute<Marcas, String> descripcion;
    public static volatile SingularAttribute<Marcas, String> codigo;
    public static volatile SingularAttribute<Marcas, String> estado;
    public static volatile ListAttribute<Marcas, Articulos> articulosList;
    public static volatile SingularAttribute<Marcas, Integer> id;

}