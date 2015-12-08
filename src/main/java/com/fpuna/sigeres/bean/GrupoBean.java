package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Grupos;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "grupobean")
@SessionScoped
public class GrupoBean implements Serializable {

    private Grupos grupo = new Grupos();
    private List<Grupos> lista;

    public void guardar() {
        try {
            if (grupo.getId() == null) {
                DaoFactory.getGrupoDAO().add(grupo);
            } else {
                DaoFactory.getGrupoDAO().edit(grupo);
            }
        } catch (Exception ex) {

        }
    }

    public void inactivar() {
        try {
            DaoFactory.getGrupoDAO().delete(grupo);
        } catch (Exception e) {

        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getGrupoDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getGrupoDAO().getAll("ACTIVO");
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarTabla(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getGrupoDAO().getAll();
                }
            } else {
                lista = DaoFactory.getGrupoDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
//-------------Setter and Getter---------------------

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public List<Grupos> getLista() {
        return lista;
    }

    public void setLista(List<Grupos> lista) {
        this.lista = lista;
    }

}
