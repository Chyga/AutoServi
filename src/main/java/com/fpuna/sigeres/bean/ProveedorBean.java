package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Proveedores;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "proveedorbean")
@ViewScoped
public class ProveedorBean implements Serializable {

    private Proveedores proveedor = new Proveedores();
    private List<Proveedores> lista;
    private List<Proveedores> listafiltro;

    public void guardar() {
        try {
            proveedor.setCodigo(proveedor.getCodigo().toUpperCase());
            if (proveedor.getId() == null) {
                proveedor = DaoFactory.getProveedorDAO().add(proveedor);
            } else {
                proveedor = DaoFactory.getProveedorDAO().edit(proveedor);
            }
            if (proveedor != null) {
                Messages.infoMessage("Exito");
                resetFields();
            } else {
                Messages.errorMessage("error");
            }

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
    }
     public void guardarCombo() {
        try {
            proveedor.setCodigo(proveedor.getCodigo().toUpperCase());
            if (proveedor.getId() == null) {
                proveedor = DaoFactory.getProveedorDAO().add(proveedor);
                listarCombo(true);
                proveedor = new Proveedores();
            } 
        } catch (Exception e) {
           
        }
    }

    public void inactivar() {
        try {
            DaoFactory.getProveedorDAO().delete(proveedor);
        } catch (Exception e) {

        }
    }

    private void resetFields() {
        this.proveedor = new Proveedores();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getProveedorDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getProveedorDAO().getAll("ACTIVO");
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
                    lista = DaoFactory.getProveedorDAO().getAll();
                }
            } else {
                lista = DaoFactory.getProveedorDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
//-------------Setter and Getter---------------------
    public boolean isEdicion(){
        return proveedor.getId() == null;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedores> getLista() {
        return lista;
    }

    public void setLista(List<Proveedores> lista) {
        this.lista = lista;
    }

    public List<Proveedores> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Proveedores> listafiltro) {
        this.listafiltro = listafiltro;
    }

}
