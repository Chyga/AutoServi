package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Usuarios;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Usuarios.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Usuarios retorno = null;
        
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getUsuarioDAO().getById(id);
        }
        return (retorno == null) ? new Usuarios() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Usuarios usuario = (Usuarios) value;
            return (usuario.getId() == null ? null : usuario.toString());
        }
        return "";
    }

}
