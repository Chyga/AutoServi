package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.modelo.Depositos;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "pedidoBean")
@ViewScoped
public class PedidoBean implements Serializable {

    //propiedades
    private List<String> listPedido;
    private String fechaCreacion;
    private int numeroDepedido;
    private List<String> selectedPedidos;

    //metodos
    

    public void addOrderNumber() {

    }

    @PostConstruct
    public void init() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.fechaCreacion = dateFormat.format(date);
    }

    public void onRowEdit(RowEditEvent event) {
        /*FacesMessage msg = new FacesMessage("Car Edited", ((Depositos) event.getObject()).getId());
         FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }

    public void onRowCancel(RowEditEvent event) {
        /*FacesMessage msg = new FacesMessage("Edit Cancelled", ((Depositos) event.getObject()).getId());
         FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    //contructor
    public PedidoBean() {
        listPedido = new ArrayList();
        selectedPedidos = new ArrayList();
    }

    //setters,getters
    public List<String> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<String> listPedido) {
        this.listPedido = listPedido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getNumeroDepedido() {
        return numeroDepedido;
    }

    public void setNumeroDepedido(int numeroDepedido) {
        this.numeroDepedido = numeroDepedido;
    }

    public List<String> getSelectedPedidos() {
        return selectedPedidos;
    }

    public void setSelectedPedidos(List<String> selectedPedidos) {
        this.selectedPedidos = selectedPedidos;
    }

}
