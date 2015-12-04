package com.sigeres.bean;

import com.sigeres.conexionbase.ABMUsuario;
import com.sigeres.entidades.Usuario;
import com.sigeres.mensajesistema.MensajeSistema;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario dao = new Usuario();
    private List<Usuario> lista;
    private List<Usuario> usuariosFiltrados;
    private String claveconfirmacion;
    private String nombreVentana;
    private String msgDialogo;
    private boolean editando;
    private MensajeSistema mensajesistema = new MensajeSistema();
    FacesMessage msg = null;
    
    private List<Usuario> selectUser;
    
    public void limpiar() {

        dao = new Usuario();

    }

    public void registrar() throws Exception {
        ABMUsuario abmusuario;
        if (!dao.getCodigo().equals("") && !dao.getClave().equals("") && !dao.getEstado().equals("")) {
            try {
                abmusuario = new ABMUsuario();
                if (abmusuario.buscar(dao).getNombre().equals("")) {
                    abmusuario.registrar(dao);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getCreacion(), dao.getCodigo().toUpperCase());
                    //this.limpiar();
                    this.listar(true);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('wvUsuario').hide();");
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getCreacionNo(), mensajesistema.getErrorCreacionCodigoDuplicado() + dao.getCodigo().toUpperCase());
                }
            } catch (Exception e) {
                throw e;
            } finally {
                this.listar(true);
                // FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void inactivar() throws Exception {
        ABMUsuario abmusuario;
        try {
            abmusuario = new ABMUsuario();
            abmusuario.inactivar(dao);
            this.listar(true);
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void modificar() throws Exception {
        ABMUsuario abmusuario;
        try {
            abmusuario = new ABMUsuario();
            abmusuario.modificar(dao);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getRegistroActualizado(), dao.getCodigo().toUpperCase());
            //this.limpiar();
            this.listar(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('wvUsuario').hide();");
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getRegistroNoActualizado(), mensajesistema.getErrorCreacionCodigoDuplicado() + dao.getCodigo().toUpperCase());
            throw e;
        } finally {

        }
    }

    public void confirmar() throws Exception {
        if (!isEditando()) {
            registrar();
        } else {
            modificar();
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
                    lista = abmusuario.listar();
                }
            } else {
                abmusuario = new ABMUsuario();
                lista = abmusuario.listar();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void buscar(Usuario usrs) throws Exception {
        Usuario Aux;
        ABMUsuario abmusuario;
        try {
            abmusuario = new ABMUsuario();
            Aux = abmusuario.buscar(usrs);
            if (Aux != null) {
                this.dao = Aux;
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
    
    public void onSelect(SelectEvent event) throws IOException {

        String codigo = ((Usuario)event.getObject()).getCodigo();
        redirect(codigo);
        
    }
    public void onEditClick() throws IOException {
        redirect(this.dao.getCodigo());
    }
    
    private void redirect(String code) throws IOException{
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("usuario.jsf?codigo="+code);
    }
    
    public void porCodigo() {

        if (this.dao.getCodigo() != null) 
        {
            ABMUsuario usuarioDAO = null;
            try {
                String code = this.dao.getCodigo();

                usuarioDAO = new ABMUsuario();
                this.dao = usuarioDAO.porCodigo(this.dao.getCodigo());

            } catch (Exception e) {

            }
        }
    }


    /*SETTER Y GETTERS*/
    public boolean isEditando() {
        return this.dao.getCodigo() != null;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getDao() {
        return dao;
    }

    public void setDao(Usuario dao) {
        this.dao = dao;
    }

    
    public List<Usuario> getUsuariosFiltrados() {
        return usuariosFiltrados;
    }

    public void setUsuariosFiltrados(List<Usuario> usuriosFiltrados) {
        this.usuariosFiltrados = usuriosFiltrados;
    }

    public String getClaveconfirmacion() {
        return claveconfirmacion;
    }

    public void setClaveconfirmacion(String claveconfirmacion) {
        this.claveconfirmacion = claveconfirmacion;
    }

    public String getNombreVentana() {
        return nombreVentana;
    }
    

    public void setNombreVentana(String nombreVentana) {
        this.nombreVentana = nombreVentana;
    }

    public MensajeSistema getMensajesistema() {
        return mensajesistema;
    }

    public void setMensajesistema(MensajeSistema mensajesistema) {
        this.mensajesistema = mensajesistema;
    }

    public FacesMessage getMsg() {
        return msg;
    }

    public void setMsg(FacesMessage msg) {
        this.msg = msg;
    }

    public String getMsgDialogo() {
        return msgDialogo;
    }

    public void setMsgDialogo(String msgDialogo) {
        this.msgDialogo = msgDialogo;
    }

    public List<Usuario> getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(List<Usuario> selectUser) {
        this.selectUser = selectUser;
    }

}
