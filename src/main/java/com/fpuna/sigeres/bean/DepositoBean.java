package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Depositos;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "depositobean")
@ViewScoped
public class DepositoBean implements Serializable {

    private Depositos deposito = new Depositos();
    private List<Depositos> lista;
    private List<Depositos> item;
    private List<Depositos> listafiltro;

    //metodos
    public String guardar() {
        try {
            if (deposito.getId() == null) {
                DaoFactory.getDepositoDAO().add(deposito);
            } else {
                DaoFactory.getDepositoDAO().edit(deposito);
            }
            Messages.infoMessage("Exito");
            resetFields();

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
        return "/deposito/depositoform.xhtml";
    }

    public void inactivar() {
        try {
            DaoFactory.getDepositoDAO().delete(deposito);
            listarTabla(true);
        } catch (Exception e) {

        }
    }

    public boolean isEditando() {
        return deposito.getId() != null;
    }

    private void resetFields() {
        this.deposito = new Depositos();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getDepositoDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getDepositoDAO().getAll("ACTIVO");
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarTabla(boolean isback) {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getDepositoDAO().getAll();
                    listafiltro = lista;
                }
            } else {
                lista = DaoFactory.getDepositoDAO().getAll();
                listafiltro = lista;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar() {
        this.lista.remove(this.deposito);
    }
    
    public void addItem(){
        if(!noExiste())
            this.item.add(deposito);
        else 
            Messages.infoMessage("El articulo ya existe");
    }
    private boolean noExiste(){
        for(Depositos obj : item){
            if(obj.equals(deposito)){
                return true;
            }
        }
        return false;
    }
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Deposito Edited", Integer.toString(((Depositos) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", Integer.toString(((Depositos) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    //constructor

    public DepositoBean() {
        this.deposito = new Depositos();
        this.item = new ArrayList<>();
    }

    //Setter,getters
    public Depositos getDeposito() {
        return deposito;
    }

    public void setDeposito(Depositos deposito) {
        this.deposito = deposito;
    }

    public List<Depositos> getLista() {
        return lista;
    }

    public void setLista(List<Depositos> lista) {
        this.lista = lista;
    }

    public List<Depositos> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Depositos> listafiltro) {
        this.listafiltro = listafiltro;
    }

    public List<Depositos> getItem() {
        return item;
    }

    public void setItem(List<Depositos> item) {
        this.item = item;
    }

 
}
