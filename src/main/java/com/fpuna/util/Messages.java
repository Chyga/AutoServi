package com.fpuna.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {

    public static void errorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
    }

    public static void infoMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }
}
