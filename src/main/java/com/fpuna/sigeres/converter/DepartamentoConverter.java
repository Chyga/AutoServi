package com.fpuna.sigeres.converter;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Departamentos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Departamentos.class)
public class DepartamentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Departamentos retorno = null;
        if (value != null && "" != value) {
            Integer id = new Integer(value);
            retorno = DaoFactory.getDepartamentoDAO().getById(id);
        }
        return (retorno == null) ? new Departamentos() : retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {

            Departamentos departamento = (Departamentos) value;
            return (departamento.getId() == null ? null : departamento.toString());
        }
        return "";
    }

}
