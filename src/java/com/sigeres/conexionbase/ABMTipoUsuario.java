/*
 COPIIA DEL USUARIOBEAN, FALTA MODIFICAR TODOS LOS METODOS Y HACER VOLAR TODO LO
 QUE SEA USUARIO.
 MODIFICADO METODO LISTAR() Y GETLSTTIPOUSUARIO.
 LISTA LOS TIPOS USUARIO EN LA LISTA LSTTIPOUSUARIO
 XD
 */
package com.sigeres.conexionbase;

import com.sigeres.entidades.TipoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ABMTipoUsuario extends BasedeDatos {

    public void registrar(TipoUsuario dao) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO TIPOUSUARIO ( `codigo`, `descripcion`, `estado`,`chkcaja`,`chkcompra`,`chkusuario`,`chkfactura`,`chkinventario`,`chkventa`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dao.getCodigo().toUpperCase());
            ps.setString(2, dao.getDescripcion());
            ps.setString(3, dao.getEstado().toUpperCase());
            ps.setInt(4, dao.getChkcaja());
            ps.setInt(5, dao.getChkcompra());
            ps.setInt(6, dao.getChkusuario());
            ps.setInt(7, dao.getChkfactura());
            ps.setInt(8, dao.getChkinventario());
            ps.setInt(9, dao.getChkventa());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void modificar(TipoUsuario dao) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("UPDATE TIPOUSUARIO SET DESCRIPCION =?,ESTADO =?,CHKCAJA =?, CHKCOMPRA =?, CHKUSUARIO =?, CHKFACTURA =?, CHKINVENTARIO =?, CHKVENTA =? WHERE CODIGO =?");
            ps.setString(1, dao.getDescripcion());
            ps.setString(2, dao.getEstado().toUpperCase());
            ps.setInt(3, dao.getChkcaja());
            ps.setInt(4, dao.getChkcompra());
            ps.setInt(5, dao.getChkusuario());
            ps.setInt(6, dao.getChkfactura());
            ps.setInt(7, dao.getChkinventario());
            ps.setInt(8, dao.getChkventa());
               ps.setString(9, dao.getCodigo().toUpperCase());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public TipoUsuario buscar(TipoUsuario dao) throws Exception {
        TipoUsuario auxdao = new TipoUsuario();
        ResultSet rs;
        //usr = null;
        try {
            auxdao.setCodigo("");
            auxdao.setDescripcion("");
            auxdao.setEstado("");
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM TIPOUSUARIO  WHERE CODIGO = ?");
            ps.setString(1, dao.getCodigo().toUpperCase());
            rs = ps.executeQuery();
            while (rs.next()) {
                auxdao.setId_tipousuario(rs.getInt("id_tipousuario"));
                auxdao.setCodigo(rs.getString("codigo"));
                auxdao.setDescripcion(rs.getString("descripcion"));
                auxdao.setChkventa(rs.getInt("chkventa"));
                auxdao.setChkcompra(rs.getInt("chkcompra"));
                auxdao.setChkusuario(rs.getInt("chkusuario"));
                auxdao.setChkinventario(rs.getInt("chkinventario"));
                auxdao.setChkcaja(rs.getInt("chkcaja"));
                auxdao.setChkfactura(rs.getInt("chkfactura"));
                auxdao.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return auxdao;
    }

    public void inactivar(TipoUsuario dao) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("UPDATE TIPOUSUARIO SET CHKCAJA=0,CHKVENTA=0,CHKCOMPRA=0,CHKUSUARIO=0,CHKINVENTARIO=0,CHKFACTURA=0,ESTADO ='INACTIVO' WHERE CODIGO =?");
            ps.setString(1, dao.getCodigo().toUpperCase());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<TipoUsuario> listar() throws Exception {
        List<TipoUsuario> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareCall("SELECT TU.* FROM TIPOUSUARIO TU WHERE TU.ESTADO = 'ACTIVO'");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                TipoUsuario dao = new TipoUsuario();
                dao.setId_tipousuario(rs.getInt("id_tipousuario"));
                dao.setCodigo(rs.getString("codigo"));
                dao.setDescripcion(rs.getString("descripcion"));
                dao.setChkventa(rs.getInt("chkventa"));
                dao.setChkcompra(rs.getInt("chkcompra"));
                dao.setChkusuario(rs.getInt("chkusuario"));
                dao.setChkinventario(rs.getInt("chkinventario"));
                dao.setChkcaja(rs.getInt("chkcaja"));
                dao.setChkfactura(rs.getInt("chkfactura"));
                dao.setEstado(rs.getString("estado"));
                lista.add(dao);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
}
