package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Proveedores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Proveedores.class)
public class ProveedroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Proveedores retorno = null;
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getProveedorDAO().getById(id);
        }
        return (retorno == null) ? new Proveedores() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Proveedores proveedor = (Proveedores) value;
            return (proveedor.getId() == null ? null : proveedor.toString());
        }
        return "";
    }

}
