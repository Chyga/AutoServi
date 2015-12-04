package com.sigeres.conexionbase;

import com.sigeres.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ABMUsuario extends BasedeDatos{
    private String SQL;
    public void registrar(Usuario dao) throws Exception{
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("INSERT INTO USUARIOS (codigo,clave,nombre,apellido,id_tipousuario,estado) VALUES (?,?,?,?,?,?)");
            ps.setString(1, dao.getCodigo().toUpperCase());
            ps.setString(2, dao.getClave());
            ps.setString(3, dao.getNombre());
            ps.setString(4, dao.getApellido());
            ps.setInt(5, dao.getId_tipousuario());
            ps.setString(6, dao.getEstado().toUpperCase());
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public void modificar(Usuario dao) throws Exception{
        //agrega campos a modificar segun venga completo.. en este caso puede cambiar o no la clave
        SQL = "UPDATE USUARIOS SET";
        if(!dao.getClave().isEmpty())SQL = SQL+" CLAVE = '"+dao.getClave()+"',";
        if(!dao.getNombre().isEmpty())SQL = SQL+" NOMBRE = '"+dao.getNombre()+"',";
        if(!dao.getApellido().isEmpty())SQL = SQL+" APELLIDO = '"+dao.getApellido()+"',";
        SQL = SQL+"  ID_TIPOUSUARIO = "+dao.getId_tipousuario()+",";
        SQL = SQL+" ESTADO = UPPER('"+dao.getEstado()+"')";
        SQL = SQL+" WHERE UPPER(CODIGO) =UPPER('"+dao.getCodigo()+"')";
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(SQL);
            /*
            ps.setString(1, usr.getClave());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setInt(4, usr.getId_tipousuario());
            ps.setString(5, usr.getEstado().toLowerCase());
            ps.setString(6, usr.getCodigo().toUpperCase());
            */
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public Usuario buscar(Usuario dao) throws Exception{
        Usuario auxdao =new Usuario();
        ResultSet rs;
        //usr = null;
        try {
            auxdao.setCodigo("");
            auxdao.setClave("");
            auxdao.setNombre("");
            auxdao.setApellido("");
            auxdao.setId_tipousuario(0);
            auxdao.setEstado("");
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM USUARIOS  WHERE codigo = ?");
            ps.setString(1, dao.getCodigo().toUpperCase());
            rs = ps.executeQuery();
            while (rs.next()){
                auxdao.setCodigo(rs.getString("codigo"));
                auxdao.setClave(rs.getString("clave"));
                auxdao.setNombre(rs.getString("nombre"));
                auxdao.setApellido(rs.getString("apellido"));
                auxdao.setId_tipousuario(rs.getInt("id_tipousuario"));
                auxdao.setEstado(rs.getString("estado"));
            }
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
        return auxdao;
    }
    public void inactivar(Usuario dao) throws Exception{
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("UPDATE usuarios SET  estado = ? WHERE codigo = ?");
            ps.setString(1, "INACTIVO");
            ps.setString(2, dao.getCodigo().toLowerCase());
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public List<Usuario> listar() throws Exception{
        List<Usuario> lista = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareCall("SELECT U.*, TU.DESCRIPCION DESTIPOUSUARIO FROM USUARIOS U JOIN TIPOUSUARIO TU ON (U.ID_TIPOUSUARIO = TU.ID_TIPOUSUARIO) WHERE U.ESTADO = 'ACTIVO'");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()){
                Usuario dao = new Usuario();
                dao.setCodigo(rs.getString("codigo"));
                dao.setClave(rs.getString("clave"));
                dao.setNombre(rs.getString("nombre"));
                dao.setApellido(rs.getString("apellido"));
                dao.setId_tipousuario(rs.getInt("id_tipousuario"));
                dao.setDestipousuario(rs.getString("destipousuario"));
                dao.setEstado(rs.getString("estado"));
                lista.add(dao);                
            }
        }catch(Exception e){
           throw e; 
        }finally{
          this.Cerrar();
        }
        return lista;
    }
    
    public Usuario porCodigo(String code) {
        Usuario usuario = null;
        
        try {
            
            ResultSet resultSet;
            usuario = new Usuario();

            this.Conectar();

            PreparedStatement preparedStatement = this.getConexion().prepareStatement("SELECT * FROM usuarios WHERE codigo = ?");
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {

                usuario.setCodigo(resultSet.getString("codigo"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setClave(resultSet.getString("clave"));
                
            }

        } catch (Exception e) {

        }
        return usuario;
    }
}
