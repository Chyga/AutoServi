package com.sigeres.bean;

import com.sigeres.conexionbase.ABMGenerico;
import com.sigeres.entidades.Usuario;
import com.sigeres.mensajesistema.MensajeSistema;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class UsuarioBean2 {

    private Usuario usuario = new Usuario();
    private List<Usuario> lstUsuario;
    private String claveconfirmacion;
    private String nombreVentana;
    private String SQL;
    private MensajeSistema mensajesistema = new MensajeSistema();
    FacesMessage msg = null;

    public String getClaveconfirmacion() {
        return claveconfirmacion;
    }

    public void setClaveconfirmacion(String claveconfirmacion) {
        this.claveconfirmacion = claveconfirmacion;
    }

    public void limpiar() {
        /*usuario.setcodigo("");
        usuario.setClave("");
        usuario.setNombre("");
        usuario.setApellido("");
        usuario.setId_tipousuario(0);
        usuario.setEstado("Activo");*/
        usuario = new Usuario();
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public void registrar() throws Exception {
        ABMGenerico abm;
        if (!usuario.getCodigo().equals("") && !usuario.getClave().equals("") && !usuario.getEstado().equals("")) {
            SQL = "SELECT * FROM USUARIOS  WHERE CODIGO = " + usuario.getCodigo();
            try {
                abm = new ABMGenerico();
                if (abm.buscar(SQL)!=null) {
                    SQL = "INSERT INTO USUARIOS (codigo,clave,nombre,apellido,id_tipousuario,estado)";
                    SQL = SQL.concat(" VALUES ('"+usuario.getCodigo()+"','"+usuario.getClave()+"','"+usuario.getNombre()+"'");
                    SQL = SQL.concat(",'"+usuario.getApellido()+"',"+usuario.getId_tipousuario()+",'"+usuario.getEstado()+"')");
                    abm.registrar(SQL);
                    //msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getCreacionUsuario(), usuario.getCodigo().toUpperCase());
                    //this.limpiar();
                  //  this.listar(true);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('wvUsuario').hide();");
                } else {
                    //msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getCreacionUsuarioNo(), mensajesistema.getErrorCreacionCodigoDuplicado() + usuario.getCodigo().toUpperCase());
                }
            } catch (Exception e) {
                throw e;
            } finally {
             //   this.listar(true);
               // FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void inactivar() throws Exception {
        ABMGenerico abm;
        SQL="UPDATE USUARIOS SET ESTADO = 'INACTIVO' WHERE CODIGO ='"+usuario.getCodigo()+"'";
        try {
            abm = new ABMGenerico();
            if (abm.inactivar(SQL)){
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getConfirmacionoperacion(),mensajesistema.getOperacioneliminar());
            }else{
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getFallaoperacion(), mensajesistema.getOperacioneliminar());
            }        
        //    this.listar(true);
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
/*
    public void modificar() throws Exception {
        ABMUsuario abmusuario;
        try {
            abmusuario = new ABMUsuario();
            if (abmusuario.buscar(usuario) == null) {
                abmusuario.modificar(usuario);
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getRegistroActualizado(), usuario.getCodigo().toUpperCase());
                //this.limpiar();
                this.listar(true);
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('wvUsuario').hide();");
            } else {
                this.listar(true);
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getRegistroNoActualizado(), mensajesistema.getErrorCreacionCodigoDuplicado() + usuario.getCodigo().toUpperCase());
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listar(boolean isback) throws Exception {
        ABMUsuario abmusuario;
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    abmusuario = new ABMUsuario();
                    lstUsuario = abmusuario.listar();
                }
            } else {
                abmusuario = new ABMUsuario();
                lstUsuario = abmusuario.listar();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void buscar(Usuario usrs) throws Exception {
        Usuario Aux;
        ABMUsuario abmusuario;
        try {
            abmusuario = new ABMUsuario();
            Aux = abmusuario.buscar(usrs);
            if (Aux != null) {
                this.usuario = Aux;
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }

    }
 
    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public String getNombreVentana() {
        return nombreVentana;
    }

    public void setNombreVentana(String nombreVentana) {
        this.nombreVentana = nombreVentana;
    }
  */  
}

