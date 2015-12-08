/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.controlador;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Usuarios;
import com.fpuna.util.Messages;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean
@SessionScoped
public class LoginControlador implements Serializable {

    private Usuarios user;
    private boolean logedIn;
    private String currentPasswordPut;
    private String newPassword;
    private DefaultStreamedContent imagen;

    public LoginControlador() {
        user = new Usuarios();
    }

    public boolean estaLogeado() {
        return logedIn;
    }

    /*obtenemos la foto del usuario*/
    public void getImg() {

        byte[] img;
        try {

            img = DaoFactory.getUsuarioDAO().getImage(user.getId());

            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                imagen = new DefaultStreamedContent();
            } else {
                if (img == null) {
                    imagen = new DefaultStreamedContent();
                } else {
                    imagen = new DefaultStreamedContent(new ByteArrayInputStream(img), "image/png");
                }
            }
        } catch (Exception e) {
            imagen = new DefaultStreamedContent();
        }
    }

    public void loguear() {
        Usuarios exists;
        try {
            exists = DaoFactory.getUsuarioDAO().findByUsuarioClave(user.getCodigo().toUpperCase(), user.getClave().toUpperCase());
            if (exists != null) {
                logedIn = true;
                user = exists;
                getImg();

                Messages.infoMessage("Bienvenido " + user.getNombre());
                RequestContext.getCurrentInstance().addCallbackParam("logeado", logedIn);
            } else {
                Messages.errorMessage("Usuario no valido");
            }
        } catch (Exception e) {
            Messages.errorMessage("error al procesar");
        }
    }
    public void function(){
        Messages.infoMessage(newPassword);
    }
    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

        logedIn = false;
    }

    public String changePassword() {
        if (!currentPasswordPut.equals(user.getClave())) {
            Messages.errorMessage("La contraseña actual ingresada no coincide");
        } else {

            user.setClave(newPassword);

            DaoFactory.getUsuarioDAO().edit(user);
            Messages.infoMessage("La contraseña ha sido cambiada satisfactoriamente");
            return "";
        }
        return null;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public boolean isLogedIn() {
        return logedIn;
    }

    public void setLogedIn(boolean logedIn) {
        this.logedIn = logedIn;
    }

    public String getCurrentPasswordPut() {
        return currentPasswordPut;
    }

    public void setCurrentPasswordPut(String currentPasswordPut) {
        this.currentPasswordPut = currentPasswordPut;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public DefaultStreamedContent getImagen() {
        return imagen;
    }

    public void setImagen(DefaultStreamedContent imagen) {
        this.imagen = imagen;
    }

   
}
