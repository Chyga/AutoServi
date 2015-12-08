package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Ciudades;
import com.fpuna.sigeres.modelo.Clientes;
import com.fpuna.sigeres.modelo.Departamentos;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private Clientes cliente;
    private List<Clientes> lista;
    private List<Clientes> listafiltro;
    private String path;
    private List<Ciudades> ciudades;

    //metodos
    public void guardar() {
        try {
            if (cliente.getCliId() == null) {
                if(DaoFactory.getClienteDAO().edit(cliente) == null) throw new Exception();
            } else {
                if(DaoFactory.getClienteDAO().edit(cliente) == null) throw new Exception();
            }
            listarTabla(true);
            Messages.infoMessage("Datos almacenados correctamente");
            resetFields();

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
    }

    public void inactivar() {
        try {
            DaoFactory.getClienteDAO().delete(cliente);
            listarTabla(true);
        } catch (Exception e) {

        }
    }
    public void ciudadesPorIdDepartamento(Departamentos _id){
        try {
            ciudades = DaoFactory.getDepartamentoDAO().cityById(_id);
        } catch (Exception e) {
        }
    }

    private void resetFields() {
        this.cliente = new Clientes();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public boolean isEditando() {
        return cliente.getCliId()!= null;
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getClienteDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getClienteDAO().getAll("ACTIVO");
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
                    lista = DaoFactory.getClienteDAO().getAll();
                }
            } else {
                lista = DaoFactory.getClienteDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void navegar(String page) {
        this.path = "/WEB-INF/templates/clientes/" + page + ".xhtml";
    }

    //constructor
    public ClienteBean() {
        this.cliente = new Clientes();
        this.path = "/WEB-INF/templates/clientes/add.xhtml";
    }

    //Setter,getters

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Clientes> getLista() {
        return lista;
    }

    public void setLista(List<Clientes> lista) {
        this.lista = lista;
    }

    public List<Clientes> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Clientes> listafiltro) {
        this.listafiltro = listafiltro;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Ciudades> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudades> ciudades) {
        this.ciudades = ciudades;
    }
   
}
