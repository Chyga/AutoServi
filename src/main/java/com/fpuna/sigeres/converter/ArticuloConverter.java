package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Articulos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Articulos.class)
public class ArticuloConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Articulos retorno = null;
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getArticuloDAO().getById(id);
        }
        return (retorno == null) ? new Articulos() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Articulos articulo = (Articulos) value;
            return (articulo.getId() == null ? null : articulo.toString());
        }
        return "";
    }

}
