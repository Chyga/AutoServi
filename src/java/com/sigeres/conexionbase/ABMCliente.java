package com.sigeres.conexionbase;

import com.sigeres.bean.LoginBean;
import com.sigeres.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ABMCliente extends BasedeDatos{
    String SQL;
    LoginBean loginBean;
    public void registrar(Cliente dao) throws Exception{
        try {
            SQL ="INSERT INTO CLIENTES (CODIGO";
            if(!dao.getRazonsocial().isEmpty()) SQL = SQL+",RAZONSOCIAL";
            if(!dao.getDireccion().isEmpty()) SQL = SQL+",DIRECCION";
            if(!dao.getTelefono().isEmpty()) SQL = SQL+",TELEFONO";
            if(!dao.getCelular().isEmpty()) SQL = SQL+",CELULAR";
            if(!dao.getRuc().isEmpty()) SQL = SQL+",RUC";
            if(!dao.getContacto().isEmpty()) SQL = SQL+",CONTACTO";
            if(!dao.getEmail().isEmpty()) SQL = SQL+",EMAIL";
            SQL = SQL+",ID_CONDICION,ID_CIUDAD,ID_DEPARTAMENTO,MODIFICADO_POR, ESTADO)";
            SQL = SQL+"VALUES ('"+dao.getCodigo()+"'";
            if(!dao.getRazonsocial().isEmpty()) SQL = SQL+",'"+dao.getRazonsocial()+"'";
            if(!dao.getDireccion().isEmpty()) SQL = SQL+",'"+dao.getDireccion()+"'";
            if(!dao.getTelefono().isEmpty()) SQL = SQL+",'"+dao.getTelefono()+"'";
            if(!dao.getCelular().isEmpty()) SQL = SQL+",'"+dao.getCelular()+"'";
            if(!dao.getRuc().isEmpty()) SQL = SQL+",'"+dao.getRuc()+"'";
            if(!dao.getContacto().isEmpty()) SQL = SQL+",'"+dao.getContacto()+"'";
            if(!dao.getEmail().isEmpty()) SQL = SQL+",'"+dao.getEmail()+"'";
            SQL = SQL+","+dao.getId_condicion()+","+dao.getId_ciudad()+","+dao.getId_departamento()+",'"+loginBean.getUser().getCodigo()+"','"+dao.getEstado()+"'";
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(SQL);
            /*
            ps.setString(1, clien.getCodigo().toUpperCase());
            ps.setString(2, clien.getRazonsocial());
            ps.setString(3, clien.getDireccion());
            ps.setString(4, clien.getRuc());
            ps.setInt(5, clien.getId_condicion());
            ps.setInt(6, clien.getId_listaprecio());
            ps.setString(7, clien.getTelefono());
            ps.setString(8, clien.getCelular());
            ps.setString(9, clien.getNombrecontacto());
            ps.setString(10, clien.getNombrefantasia());
            ps.setString(11, clien.getEstado().toUpperCase());
            */
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public void modificar(Cliente dao) throws Exception{
        try {
            SQL ="UPDATE CLIENTE SET";
            if(!dao.getRazonsocial().isEmpty()) SQL = SQL+"RAZONSOCIAL ='"+dao.getRazonsocial()+"'";
            if(!dao.getDireccion().isEmpty()) SQL = SQL+",DIRECCION ='"+dao.getDireccion()+"'";
            if(!dao.getTelefono().isEmpty()) SQL = SQL+",TELEFONO ='"+dao.getDireccion()+"'";
            if(!dao.getCelular().isEmpty()) SQL = SQL+",CELULAR ='"+dao.getCelular()+"'";
            if(!dao.getRuc().isEmpty()) SQL = SQL+",RUC ='"+dao.getRuc()+"'";
            if(!dao.getContacto().isEmpty()) SQL = SQL+",CONTACTO ='"+dao.getContacto()+"'";
            if(!dao.getEmail().isEmpty()) SQL = SQL+",EMAIL ='"+dao.getEmail()+"'";
            SQL = SQL+",ID_CONDICION ='"+dao.getId_condicion()+",ID_CIUDAD ='"+dao.getId_ciudad()+",ID_DEPARTAMENTO ='"+dao.getId_departamento();
            SQL = SQL+ ",MODIFICADO_POR ='"+loginBean.getUser().getCodigo()+", ESTADO ='"+dao.getEstado()+"'";
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement(SQL);
            /*
            ps.setString(1, clien.getClave());
            ps.setString(2, clien.getNombre());
            ps.setString(3, clien.getApellido());
            ps.setInt(4, clien.getId_tipousuario());
            ps.setString(5, clien.getEstado().toLowerCase());
            ps.setString(6, clien.getCodigo().toUpperCase());
            */
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public Cliente buscar(Cliente dao) throws Exception{
        Cliente auxdao =new Cliente();
        ResultSet rs;
        //clien = null;
        try {
           /*
            auxdao.setCodigo("");
            auxdao.setClave("");
            auxdao.setNombre("");
            auxdao.setApellido("");
            auxdao.setId_tipousuario(0);
            auxdao.setEstado("");*/
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("SELECT * FROM CLIENTES  WHERE codigo = ?");// AGREGAR JOIN CUANDO SE CREE LA TABLA DE CIUDAD DEPARTAMENTO
            ps.setString(1, dao.getCodigo().toUpperCase());
            rs = ps.executeQuery();
            while (rs.next()){
                auxdao.setCodigo(rs.getString("codigo"));
                auxdao.setCelular(rs.getString("celular"));
                auxdao.setContacto(rs.getString("contacto"));
                auxdao.setDireccion(rs.getString("direccion"));
                auxdao.setEmail(rs.getString("email"));
                auxdao.setId_ciudad(rs.getInt("id_ciudad"));
                auxdao.setId_cliente(rs.getInt("id_cliente"));
                auxdao.setId_departamento(rs.getInt("id_departamento"));
                auxdao.setEstado(rs.getString("estado"));
            }
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
        return auxdao;
    }
    public void inactivar(Cliente dao) throws Exception{
        try {
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareStatement("UPDATE CLIENTES SET  ESTADO ='INACTIVO' WHERE codigo =?");
            ps.setString(1, dao.getCodigo().toUpperCase());
            ps.executeUpdate();
            
        } catch (Exception e){
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    public List<Cliente> listar() throws Exception{
        List<Cliente> lista = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement ps = this.getConexion().prepareCall("SELECT U.*, TU.DESCRIPCION DESTIPOUSUARIO FROM CLIENTES U JOIN TIPOUSUARIO TU ON (U.ID_TIPOUSUARIO = TU.ID_TIPOUSUARIO) WHERE U.ESTADO = 'ACTIVO'");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()){
                Cliente dao =  new Cliente();
                dao.setCodigo(rs.getString("codigo"));
                dao.setCelular(rs.getString("celular"));
                dao.setContacto(rs.getString("contacto"));
                dao.setDireccion(rs.getString("direccion"));
                dao.setEmail(rs.getString("email"));
                dao.setId_ciudad(rs.getInt("id_ciudad"));
                dao.setId_cliente(rs.getInt("id_cliente"));
                dao.setId_departamento(rs.getInt("id_departamento"));
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
    
}

 