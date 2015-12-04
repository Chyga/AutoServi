package com.sigeres.bean;

import com.sigeres.conexionbase.Login;
import com.sigeres.entidades.TipoUsuario;
import com.sigeres.entidades.Usuario;
import com.sigeres.mensajesistema.MensajeSistema;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario user = new Usuario();
    private TipoUsuario tipousuario;
    private String claveconfirmacion;
    private MensajeSistema mensajesistema = new MensajeSistema();
    boolean loginIn;
    FacesMessage msg = null;

    
    public TipoUsuario getTipousuario() {
        return tipousuario;
    }
    

    public String getClaveconfirmacion() {
        return claveconfirmacion;
    }

    
    public void setClaveconfirmacion(String claveconfirmacion) {
        this.claveconfirmacion = claveconfirmacion;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void cambioclave() throws Exception {
        Login login;
        
        if (user.getClave().equals(claveconfirmacion)) {
            
            login = new Login();
            login.cambiarclave(user);
            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getClaveCambio(), user.getCodigo().toUpperCase());
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('wvCambioClave').hide();");
           
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        } else {
            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getErrorClaveCambio(), mensajesistema.getCodigosDiferentes());
            
        }
    }

    public String loginSistema() {
        //RequestContext context = RequestContext.getCurrentInstance();
        String ruta = "";
        Login login;
        loginIn = false;
        try {
            login = new Login();
            if (login.habilitado(user)) {
                loginIn = true;
                this.user.setNombre(login.getUsuario().getNombre());
                this.user.setApellido(login.getUsuario().getApellido());
                this.user.setId_tipousuario(login.getUsuario().getId_tipousuario());
                this.tipousuario = login.getTipousuario();
                ruta = "principal?faces-redirect=true";
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensajesistema.getConfimarIngreso(), user.getCodigo().toUpperCase());
            } else {
                loginIn = false;
                ruta = "";
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensajesistema.getLoginError(), mensajesistema.getReintento());

            }
        } catch (Exception e) {
            ruta = "";
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensajesistema.getLoginError(), mensajesistema.getReintento());
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //context.addCallbackParam("loginIn", loginIn);
        //context.addCallbackParam("ruta", ruta);
        return ruta;
    }

    public void logout() {
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        loginIn = false;
    }
    
    public boolean estaLogeado() {
       return this.loginIn;
    }
    
}
