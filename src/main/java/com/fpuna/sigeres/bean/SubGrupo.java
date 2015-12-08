package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Grupos;
import com.fpuna.sigeres.modelo.SubGrupos;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "subgrupobean")
@ViewScoped
public class SubGrupo implements Serializable {

    private SubGrupos subgrupo;
    private List<SubGrupos> lista;

    //metodos
    public void guardar() {
        try {
            if (subgrupo.getId() == null) {
                DaoFactory.getSubGrupoDAO().add(subgrupo);
            } else {
                DaoFactory.getSubGrupoDAO().edit(subgrupo);
            }
            Messages.infoMessage("Exito");
            resetFields();

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
    }
    public void inactivar() {
        try {
            DaoFactory.getSubGrupoDAO().delete(subgrupo);
        } catch (Exception e) {

        }
    }
    private void resetFields() {
        this.subgrupo = new SubGrupos();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getSubGrupoDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getSubGrupoDAO().getAll("ACTIVO");
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
                    lista = DaoFactory.getSubGrupoDAO().getAll();
                }
            } else {
                lista = DaoFactory.getSubGrupoDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarComboById(Grupos id) {
        try {
            if (id != null) {
                lista = DaoFactory.getSubGrupoDAO().getAll(id);
            } else {
                //lista = DaoFactory.getDepositoDAO().getAll("ACTIVO");
                lista = null;
            }
        } catch (Exception e) {

        }
    }

    //constructor
    public SubGrupo() {
        this.subgrupo = new SubGrupos();
    }

    //Setter,getters
    public SubGrupos getSubGrupo() {
        return subgrupo;
    }

    public void setSubGrupo(SubGrupos subgrupo) {
        this.subgrupo = subgrupo;
    }

    public List<SubGrupos> getLista() {
        return lista;
    }

    public void setLista(List<SubGrupos> lista) {
        this.lista = lista;
    }

}
