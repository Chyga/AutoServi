package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Ciudades;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Ciudades.class)
public class CiudadConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Ciudades retorno = null;
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getCiudadDAO().getById(id);
        }
        return (retorno == null) ? new Ciudades() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Ciudades ciudad = (Ciudades) value;
            return (ciudad.getId() == null ? null : ciudad.toString());
        }
        return "";
    }

}
