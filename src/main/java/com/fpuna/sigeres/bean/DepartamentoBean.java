
package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Departamentos;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "departamentobean")
@SessionScoped
public class DepartamentoBean implements Serializable {

    private Departamentos departamento = new Departamentos();
    private List<Departamentos> lista;
    private List<Departamentos> listafiltro;
    public void guardar() {
        try {
            if(departamento.getId()==null){
            DaoFactory.getDepartamentoDAO().add(departamento);
            }else{
             DaoFactory.getDepartamentoDAO().edit(departamento);   
            }
            Messages.infoMessage("Exito");
            resetFields();
        } catch (Exception ex) {
            Messages.errorMessage("error");
        }
    }
    public void inactivar(){
        try{
            DaoFactory.getDepartamentoDAO().delete(departamento);
            listarTabla(true);
        }catch(Exception e){
            
        }
    }
    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

     public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getDepartamentoDAO().getAll("ACTIVO");
                }
            } else {
               lista = DaoFactory.getDepartamentoDAO().getAll("ACTIVO");
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
                    lista = DaoFactory.getDepartamentoDAO().getAll();
                }
            } else {
               lista = DaoFactory.getDepartamentoDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }
    public boolean isEditando() {
        return departamento.getId() != null;
    }
    
    public void updateComponent(String _idComponent){
        
    }

    public DepartamentoBean() {
        this.departamento = new Departamentos();
        this.lista =new ArrayList<>();
        this.listafiltro = new ArrayList<>();
    }

//-------------Setter and Getter---------------------
    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }

    public List<Departamentos> getLista() {
        return lista;
    }

    public void setLista(List<Departamentos> lista) {
        this.lista = lista;
    }

    public List<Departamentos> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Departamentos> listafiltro) {
        this.listafiltro = listafiltro;
    }

    private void resetFields() {
        this.departamento = new Departamentos();
    }

    
}
