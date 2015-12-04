 package com.sigeres.filtro;



import com.sigeres.bean.LoginBean;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter checks if LoginBean has loginIn property set to true. If it is not set
 * then request is being redirected to the login.xhml page.
 *
 * @author itcuties
 *
 */
public class LoginFilter implements Filter {
    LoginBean loginBean;

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // Obtengo el bean que representa el usuario desde el scope sesión
        loginBean = (LoginBean) req.getSession().getAttribute("loginBean");

        //Proceso la URL que está requiriendo el cliente
        String urlStr = req.getRequestURL().toString().toLowerCase();
       
        //Si no requiere protección continúo normalmente.
        if (excluir(urlStr)) {
            chain.doFilter(request, response);
            return;
        }

        //El usuario no está logueado
        if (loginBean == null || !loginBean.estaLogeado()) {
            res.sendRedirect(req.getContextPath() + "/Home/login.jsf");
            return;
        }
       
        if(!tienePermiso(urlStr)){
            res.sendRedirect(req.getContextPath() + "/protegido.jsf");
            return;
        }
        //El recurso requiere protección, pero el usuario ya está logueado.
        chain.doFilter(request, response);
    }

    private boolean excluir(String urlStr) {

        /*
          Recursos que no
         * requieren protección
         */
        if (urlStr.endsWith("login.jsf")) {
            return true;
        }
        if (urlStr.indexOf("/javax.faces.resource/") != -1) {
            return true;
        }
        return false;
    }

    public void destroy() {
        // Nothing to do here!
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    private boolean tienePermiso(String urlStr){
        if(urlStr.endsWith("tipousuario.jsf"))
            if(loginBean.getTipousuario().getChkusuario()==0)
                return false;
        return true;
    }
}
