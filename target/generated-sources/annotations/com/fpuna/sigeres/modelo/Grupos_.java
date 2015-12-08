package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.SubGrupos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:52")
@StaticMetamodel(Grupos.class)
public class Grupos_ { 

    public static volatile SingularAttribute<Grupos, String> descripcion;
    public static volatile SingularAttribute<Grupos, String> codigo;
    public static volatile SingularAttribute<Grupos, String> estado;
    public static volatile ListAttribute<Grupos, Articulos> articulosList;
    public static volatile SingularAttribute<Grupos, Integer> id;
    public static volatile ListAttribute<Grupos, SubGrupos> subGruposList;

}