package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.TiposUsuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tipousuariobean")
@SessionScoped
public class TipoUsuarioBean implements Serializable {

    private TiposUsuarios tipoUsuario = new TiposUsuarios();
    private List<TiposUsuarios> lista;
    private String checkPermisos[];

    public void guardar() {
        try {
            if (tipoUsuario.getId() == null) {
                DaoFactory.getTipoUsuarioDAO().add(tipoUsuario);
            } else {
                DaoFactory.getTipoUsuarioDAO().edit(tipoUsuario);
            }
        } catch (Exception ex) {

        }
    }

    public void inactivar() {
        try {
            DaoFactory.getTipoUsuarioDAO().delete(tipoUsuario);
        } catch (Exception e) {

        }
    }

    public void prueba() {
        for(String it : checkPermisos){
            System.out.println("\n--> " + it);
        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getTipoUsuarioDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getTipoUsuarioDAO().getAll("ACTIVO");
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarPermisos() {
        //this.checkList = DaoFactory.getTipoUsuarioDAO().getAll();
    }

    public void listarTabla(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getTipoUsuarioDAO().getAll();
                }
            } else {
                lista = DaoFactory.getTipoUsuarioDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    //contructo
    public TipoUsuarioBean() {
        //lista = new ArrayList();
    }

//-------------Setter and Getter---------------------
    public TiposUsuarios getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TiposUsuarios tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TiposUsuarios> getLista() {
        return lista;
    }

    public void setLista(List<TiposUsuarios> lista) {
        this.lista = lista;
    }

    public String[] getCheckPermisos() {
        return checkPermisos;
    }

    public void setCheckPermisos(String[] checkPermisos) {
        this.checkPermisos = checkPermisos;
    }

}
