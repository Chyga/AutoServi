package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Ciudades;
import com.fpuna.sigeres.modelo.Departamentos;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ciudadbean")
@ViewScoped
public class CiudadBean implements Serializable {

    private Ciudades ciudad;
    private List<Ciudades> lista;
    private List<Ciudades> listafiltro;

    //metodos
    public void guardar() {
        try {
            if (ciudad.getId() == null) {
                DaoFactory.getCiudadDAO().add(ciudad);
            } else {
                DaoFactory.getCiudadDAO().edit(ciudad);
            }
            Messages.infoMessage("Exito");
            resetFields();

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
    }

    public void inactivar() {
        try {
            DaoFactory.getCiudadDAO().delete(ciudad);
            listarTabla(true);
        } catch (Exception e) {

        }
    }

    private void resetFields() {
        this.ciudad = new Ciudades();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public boolean isEditando() {
        return ciudad.getId() != null;
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getCiudadDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getCiudadDAO().getAll("ACTIVO");
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
                    lista = DaoFactory.getCiudadDAO().getAll();
                }
            } else {
                lista = DaoFactory.getCiudadDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarComboById(Departamentos id) {
        try {
            if (id != null) {
                lista = DaoFactory.getCiudadDAO().getAll(id);
            } else {
                //lista = DaoFactory.getCiudadDAO().getAll("ACTIVO");
                lista = null;
            }
        } catch (Exception e) {

        }
    }

    public void test(){
        Messages.infoMessage("Update");
    }
    //constructor
    public CiudadBean() {
        this.ciudad = new Ciudades();
    }

    //Setter,getters
    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudades> getLista() {
        return lista;
    }

    public void setLista(List<Ciudades> lista) {
        this.lista = lista;
    }

    public List<Ciudades> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Ciudades> listafiltro) {
        this.listafiltro = listafiltro;
    }
}
