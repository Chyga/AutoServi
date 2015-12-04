package com.sigeres.conexionbase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ABMGenerico extends BasedeDatos {

    boolean estadoOperacion;

    /*public boolean registrar(String sql) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.executeUpdate();
            estadoOperacion = true;
        } catch (Exception e) {
            estadoOperacion = false;
            throw e;
        } finally {
            this.Cerrar();
        }
        return estadoOperacion;
    }*/
    
    public boolean registrar(String sql) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.executeUpdate();
            estadoOperacion = true;
        } catch (Exception e) {
            estadoOperacion = false;
            throw e;
        } finally {
            this.Cerrar();
        }
        return estadoOperacion;
    }
    

    public boolean modificar(String sql) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.executeUpdate();
            estadoOperacion = true;
        } catch (Exception e) {
            estadoOperacion = false;
            throw e;
        } finally {
            this.Cerrar();
        }
        return estadoOperacion;
    }

    public ResultSet buscar(String sql) throws Exception {
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return rs;
    }

    public boolean inactivar(String sql) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.executeUpdate();
            estadoOperacion = true;
        } catch (Exception e) {
            estadoOperacion = false;
            throw e;
        } finally {
            this.Cerrar();
        }
        return estadoOperacion;
    }

    public ResultSet listar(String sql) throws Exception {
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareCall(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return rs;
    }
}
