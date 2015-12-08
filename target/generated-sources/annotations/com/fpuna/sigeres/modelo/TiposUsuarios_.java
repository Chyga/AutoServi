package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(TiposUsuarios.class)
public class TiposUsuarios_ { 

    public static volatile SingularAttribute<TiposUsuarios, String> descripcion;
    public static volatile ListAttribute<TiposUsuarios, Usuarios> usuariosList;
    public static volatile SingularAttribute<TiposUsuarios, String> codigo;
    public static volatile SingularAttribute<TiposUsuarios, String> estado;
    public static volatile SingularAttribute<TiposUsuarios, Integer> idPermiso;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkventa;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkcaja;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkseguridad;
    public static volatile SingularAttribute<TiposUsuarios, Integer> id;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkinventario;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkfacturacion;
    public static volatile SingularAttribute<TiposUsuarios, Integer> chkcompra;

}