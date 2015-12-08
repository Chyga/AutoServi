package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Usuarios;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuarios usuario;
    private List<Usuarios> lista;
    private Integer RangoInicial;
    private Integer Rango;

    //METODOS
    public void guardar() {
        Usuarios user;
        try {
            usuario.setCodigo(usuario.getCodigo().toUpperCase());
            if (usuario.getId() == null) {
                user = DaoFactory.getUsuarioDAO().add(usuario);
            } else {
                user = DaoFactory.getUsuarioDAO().edit(usuario);
            }
            if (user != null) {
                Messages.infoMessage("Registro Correcto");
            }
            resetFiels();

        } catch (Exception ex) {
            Messages.errorMessage("Ha ocurrido un error, intentelo nuevamente");

        }
    }

    public void eliminar(Usuarios userSelect, int linea) {
        try {
            userSelect.setEstado("INACTIVO");
            if (DaoFactory.getUsuarioDAO().edit(userSelect) != null) {
                Messages.infoMessage("Registro Invalidado");
            }
            lista.remove(linea);
        } catch (Exception e) {
            Messages.errorMessage("Ha ocurrido un error, intentelo nuevamente");
        }
    }
    
    public void activarUsuario(Usuarios user, int linea){
        try {
            user.setEstado("ACTIVO");
            if(DaoFactory.getUsuarioDAO().edit(user) != null){
                Messages.infoMessage("Activado");
            }
        } catch (Exception e) {
        }
    }

    public void listUsers(boolean postBack) {
        try {
            if(!postBack){
                if(!isPostBack()){
                     lista = DaoFactory.getUsuarioDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getUsuarioDAO().getAll("ACTIVO");
            }
            print();
        } catch (Exception e) {
            System.out.println("ha ocurrido un erro al procesar la peticion");
        }
    }
   public void allUsers(){
       this.lista = DaoFactory.getUsuarioDAO().getAll();
   }

    private void print() {
        for (Usuarios usr : lista) {
            System.out.println("\n ---> " + usr.getApellido());
        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void listarInicio() {
        this.RangoInicial = 0;
    }

    public void listarSiguiente() {
        this.RangoInicial = this.RangoInicial + this.Rango;
    }

    public void listarAnterior() {
        this.RangoInicial = this.RangoInicial - this.Rango;
        if (RangoInicial < 0) {
            RangoInicial = 0;
        }
    }

    private void resetFiels() {
        this.usuario = new Usuarios();
    }

    //CONSTRUCTOR
    public UsuarioBean() {
        this.usuario = new Usuarios();
        this.RangoInicial = 0;
        this.lista = new ArrayList<>();
        this.Rango = 10;
    }

    //SETTERS,GETTERS
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getLista() {
        return lista;
    }

    public void setLista(List<Usuarios> lista) {
        this.lista = lista;
    }

    public Integer getRangoInicial() {
        return RangoInicial;
    }

    public void setRangoInicial(Integer RangoInicial) {
        this.RangoInicial = RangoInicial;
    }

    public Integer getRango() {
        return Rango;
    }

    public void setRango(Integer Rango) {
        this.Rango = Rango;
    }
}
