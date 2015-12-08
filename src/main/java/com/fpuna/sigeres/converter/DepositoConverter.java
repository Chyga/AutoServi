package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Depositos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Depositos.class)
public class DepositoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Depositos retorno = null;
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getDepositoDAO().getById(id);
        }
        return (retorno == null) ? new Depositos() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {

            Depositos deposito = (Depositos) value;
            return (deposito.getId() == null ? null : deposito.toString());
        }
        return "";
    }

}
