package com.sigeres.bean;

import com.sigeres.conexionbase.ABMTipoUsuario;
import com.sigeres.entidades.TipoUsuario;
import com.sigeres.mensajesistema.MensajeSistema;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class TipoUsuarioBean {

    private List<TipoUsuario> lista;
    private TipoUsuario dao = new TipoUsuario();
    private String nombreVentana;
    private String SQL;
    private MensajeSistema mensajesistema = new MensajeSistema();
    FacesMessage msg = null;

    public void listar(boolean isback) throws Exception {
        ABMTipoUsuario abm;
        abm = new ABMTipoUsuario();
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = abm.listar();
                }
            } else {
                lista = abm.listar();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void limpiar() {
        dao = new TipoUsuario();
    }

    public void registrar() throws Exception {
        ABMTipoUsuario abm;
        if (!dao.getCodigo().equals("") && !dao.getDescripcion().equals("") && !dao.getEstado().equals("")) {
            try {
                abm = new ABMTipoUsuario();
                if (abm.buscar(dao).getCodigo().equals("")) {
                    abm.registrar(dao);
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getCreacionTipoUsuario(), dao.getCodigo().toUpperCase());
                    this.limpiar();
                    this.listar(true);
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('wvTipoUsuario').hide();");
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getCreacionTipoUsuarioNo(), mensajesistema.getErrorCreacionCodigoDuplicado() + dao.getCodigo().toUpperCase());
                }
            } catch (Exception e) {
                throw e;
            } finally {
                this.listar(true);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void inactivar() throws Exception {
        ABMTipoUsuario abm;
        try {
            abm = new ABMTipoUsuario();
            abm.inactivar(dao);
            this.listar(true);
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void modificar() throws Exception {
        ABMTipoUsuario abm;
        try {
            abm = new ABMTipoUsuario();
            abm.modificar(dao);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getRegistroActualizado(), dao.getCodigo().toUpperCase());
            //this.limpiar();
            this.listar(true);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('wvTipoUsuario').hide();");
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensajesistema.getRegistroNoActualizado(), mensajesistema.getFallaoperacion() + dao.getCodigo().toUpperCase());
            throw e;
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void confirmar() throws Exception {
        if (nombreVentana.equals("Registro")) {
            registrar();
        } else {
            modificar();
        }
    }

    public void buscar(TipoUsuario tipousrs) throws Exception {
        TipoUsuario Aux;
        ABMTipoUsuario abm;
        try {
            abm = new ABMTipoUsuario();
            Aux = abm.buscar(tipousrs);
            if (Aux != null) {
                this.dao = Aux;
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
    /*Setters y Getters */

    public TipoUsuario getDao() {
        return dao;
    }

    public void setDao(TipoUsuario tipousuario) {
        this.dao = tipousuario;
    }

    public String getNombreVentana() {
        return nombreVentana;
    }

    public void setNombreVentana(String nombreVentana) {
        this.nombreVentana = nombreVentana;
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public List<TipoUsuario> getLista() {
        return lista;
    }

    public void setLista(List<TipoUsuario> lista) {
        this.lista = lista;
    }

}
