package com.sigeres.bean;

import com.sigeres.conexionbase.ABMCliente;
import com.sigeres.entidades.Cliente;
import com.sigeres.mensajesistema.MensajeSistema;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente dao = new Cliente();
    private List<Cliente> lista;
    private List<Cliente> Filtrados;
    private String claveconfirmacion;
    private String nombreVentana;
    private String msgDialogo;
    private String parametro;
    private MensajeSistema mensajesistema = new MensajeSistema();
    FacesMessage msg = null;

    public void limpiar() {

        dao = new Cliente();

    }

    public void registrar() throws Exception {
        ABMCliente abm;
        if (!dao.getCodigo().equals("") && !dao.getEstado().equals("")) {
            try {
                abm = new ABMCliente();
                if (abm.buscar(dao).getCodigo().equals("")) {
                    abm.registrar(dao);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getCreacion(), dao.getCodigo().toUpperCase());
                    //this.limpiar();
                    this.listar(true);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('wvCliente').hide();");
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getCreacion(), mensajesistema.getErrorCreacionCodigoDuplicado() + dao.getCodigo().toUpperCase());
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
        ABMCliente abm;
        try {
            abm = new ABMCliente();
            abm.inactivar(dao);
            this.listar(true);
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void modificar() throws Exception {
        ABMCliente abm;
        try {
            abm = new ABMCliente();
            abm.modificar(dao);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getRegistroActualizado(), dao.getCodigo().toUpperCase());
            //this.limpiar();
            this.listar(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('wvCliente').hide();");
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getRegistroNoActualizado(), mensajesistema.getErrorCreacionCodigoDuplicado() + dao.getCodigo().toUpperCase());
            throw e;
        } finally {

        }
    }

    public void confirmar() throws Exception {
        if (nombreVentana.equals("Registro")) {
            registrar();
        } else {
            modificar();
        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listar(boolean isback) throws Exception {
        ABMCliente abm;
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    abm = new ABMCliente();
                    lista = abm.listar();
                }
            } else {
                abm = new ABMCliente();
                lista = abm.listar();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void buscar(Cliente usrs) throws Exception {
        Cliente Aux;
        ABMCliente abm;
        try {
            abm = new ABMCliente();
            Aux = abm.buscar(usrs);
            if (Aux != null) {
                this.dao = Aux;
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    /*SETTER Y GETTERS*/
    public List<Cliente> getFiltrados() {
        return Filtrados;
    }

    public void setFiltrados(List<Cliente> Filtrados) {
        this.Filtrados = Filtrados;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public Cliente getDao() {
        return dao;
    }

    public void setDao(Cliente dao) {
        this.dao = dao;
    }

    
    public List<Cliente> getClientesFiltrados() {
        return Filtrados;
    }

    public void setClientesFiltrados(List<Cliente> Filtrados) {
        this.Filtrados = Filtrados;
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

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
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

}
