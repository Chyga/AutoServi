package com.sigeres.conexionbase;

import com.sigeres.entidades.TipoUsuario;
import com.sigeres.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends BasedeDatos {

    private Usuario usuario = new Usuario();
    private TipoUsuario tipousuario = new TipoUsuario();

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean habilitado(Usuario usr) throws SQLException, Exception {
        ResultSet rs;
        boolean usuarioOk;
        usuarioOk = false;

        try {
            this.Conectar();
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM USUARIOS WHERE CLAVE = ? AND UPPER(CODIGO) = ? AND ESTADO = ?");
            st.setString(1, usr.getClave());
            st.setString(2, usr.getCodigo().toUpperCase());
            st.setString(3, "ACTIVO");
            rs = st.executeQuery();
            while (rs.next()) {
                usuarioOk = true;
                this.usuario.setCodigo(rs.getString("codigo"));
                this.usuario.setClave(rs.getString("clave"));
                this.usuario.setNombre(rs.getString("nombre"));
                this.usuario.setApellido(rs.getString("apellido"));
                this.usuario.setId_tipousuario(rs.getInt("id_tipousuario"));
                this.usuario.setEstado(rs.getString("estado"));

            }
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM TIPOUSUARIO  WHERE ID_TIPOUSUARIO = ?");
            ps.setInt(1, usuario.getId_tipousuario());
            rs = ps.executeQuery();
            while (rs.next()) {
                tipousuario.setId_tipousuario(rs.getInt("id_tipousuario"));
                tipousuario.setCodigo(rs.getString("codigo"));
                tipousuario.setDescripcion(rs.getString("descripcion"));
                tipousuario.setChkventa(rs.getInt("chkventa"));
                tipousuario.setChkcompra(rs.getInt("chkcompra"));
                tipousuario.setChkusuario(rs.getInt("chkusuario"));
                tipousuario.setChkinventario(rs.getInt("chkinventario"));
                tipousuario.setChkcaja(rs.getInt("chkcaja"));
                tipousuario.setChkfactura(rs.getInt("chkfactura"));
                tipousuario.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return usuarioOk;
    }

    public void cambiarclave(Usuario usr) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE usuarios SET CLAVE = ? WHERE CODIGO = ? ");
            st.setString(1, usr.getClave());
            st.setString(2, usr.getCodigo().toUpperCase());
            st.executeUpdate();
        } catch (Exception e) {

            throw e;
        } finally {
            this.Cerrar();
        }

    }
}
