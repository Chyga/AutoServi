package com.fpuna.sigeres.modelo;

import com.fpuna.sigeres.modelo.Depositos;
import com.fpuna.sigeres.modelo.PedidosCompras;
import com.fpuna.sigeres.modelo.TiposUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T15:36:53")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> codigo;
    public static volatile SingularAttribute<Usuarios, String> clave;
    public static volatile SingularAttribute<Usuarios, String> estado;
    public static volatile SingularAttribute<Usuarios, String> apellido;
    public static volatile SingularAttribute<Usuarios, byte[]> photo;
    public static volatile ListAttribute<Usuarios, PedidosCompras> pedidosComprasList;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, TiposUsuarios> idTipousuario;
    public static volatile SingularAttribute<Usuarios, Depositos> idDeposito;
    public static volatile SingularAttribute<Usuarios, String> nombre;

}