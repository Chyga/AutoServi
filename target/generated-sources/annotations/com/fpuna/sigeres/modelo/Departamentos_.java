package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Ciudades;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, String> descripcion;
    public static volatile SingularAttribute<Departamentos, String> estado;
    public static volatile SingularAttribute<Departamentos, Integer> id;
    public static volatile ListAttribute<Departamentos, Ciudades> ciudadesList;

}