package com.fpuna.sigeres.dao;

import com.fpuna.sigeres.filter.EntityManagerProvider;
import com.fpuna.sigeres.impl.ArticuloImpl;
import com.fpuna.sigeres.impl.CiudadImpl;
import com.fpuna.sigeres.impl.ClienteImpl;
import com.fpuna.sigeres.impl.DepartamentoImpl;
import com.fpuna.sigeres.impl.DepositoImpl;
import com.fpuna.sigeres.impl.GrupoImpl;
import com.fpuna.sigeres.impl.PedidoCompraImpl;
import com.fpuna.sigeres.impl.PedidoCompraDetalleImpl;
import com.fpuna.sigeres.impl.ProveedorImpl;
import com.fpuna.sigeres.impl.SubGrupoImpl;
import com.fpuna.sigeres.impl.TipoUsuarioImpl;
import com.fpuna.sigeres.impl.UsuarioImpl;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DaoFactory {

    public static EntityManager getEmDAO() {
        try {
            return EntityManagerProvider.get();
        } catch (Exception ex) {
            System.err.println("Causa: " + ex.getCause() + "Localize: " + ex.getLocalizedMessage());
            return Persistence.createEntityManagerFactory("PrimeFacesVentasPU").createEntityManager();
        }
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioImpl();
    }
    public static DepositoDAO getDepositoDAO() {
        return new DepositoImpl();
    }
    public static TipoUsuarioDAO getTipoUsuarioDAO() {
        return new TipoUsuarioImpl();
    }
    public static SubGrupoDAO getSubGrupoDAO(){
        return new SubGrupoImpl();
    }
    public static GrupoDAO getGrupoDAO(){
        return new GrupoImpl();
    }
    public static DepartamentoDAO getDepartamentoDAO(){
        return new DepartamentoImpl();
    }
    public static CiudadDAO getCiudadDAO(){
        return new CiudadImpl();
    }
    public static ProveedorDAO getProveedorDAO(){
        return new ProveedorImpl();
    }
    public static PedidoCompraDAO getPedidoCompraDAO(){
        return new PedidoCompraImpl();
    }
    public static PedidoCompraDetalleDAO getPedidoCompraDetalleDAO(){
        return new PedidoCompraDetalleImpl();
    }
    public static ArticuloDAO getArticuloDAO(){
        return new ArticuloImpl();
    }
    public static ClienteDAO getClienteDAO(){
        return new ClienteImpl();
    }
}
