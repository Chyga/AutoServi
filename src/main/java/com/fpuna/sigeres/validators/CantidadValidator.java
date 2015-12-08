
package com.fpuna.sigeres.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "cantidadValidator")
public class CantidadValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String label = "";
        HtmlInputText inputtext = (HtmlInputText)component;
        
        if(inputtext.getLabel() != null || inputtext.getLabel().trim().equals("")){
            label = inputtext.getId();
        }
        if(value instanceof String){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error:", label + " debe ser un campo numerico, no una letra" ));
        }
    }

}
