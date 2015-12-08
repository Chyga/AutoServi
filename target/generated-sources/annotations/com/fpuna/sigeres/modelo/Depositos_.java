package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Existencias;
import com.fpuna.sigeres.modelo.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Depositos.class)
public class Depositos_ { 

    public static volatile SingularAttribute<Depositos, String> descripcion;
    public static volatile ListAttribute<Depositos, Existencias> existenciasList;
    public static volatile ListAttribute<Depositos, Usuarios> usuariosList;
    public static volatile SingularAttribute<Depositos, String> estado;
    public static volatile SingularAttribute<Depositos, Integer> id;

}