package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.Grupos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(SubGrupos.class)
public class SubGrupos_ { 

    public static volatile SingularAttribute<SubGrupos, String> descripcion;
    public static volatile SingularAttribute<SubGrupos, String> codigo;
    public static volatile SingularAttribute<SubGrupos, String> estado;
    public static volatile ListAttribute<SubGrupos, Articulos> articulosList;
    public static volatile SingularAttribute<SubGrupos, Integer> id;
    public static volatile SingularAttribute<SubGrupos, Grupos> idGrupo;

}