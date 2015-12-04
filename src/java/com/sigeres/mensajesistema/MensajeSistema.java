/*
 Clase de mensajes, a manera de si existe un cambio en la forma de mostrar un
 mensaje, sea solo en un lugar en donde se deba cambiar.
 todos los mensajes a mostrar al usuario se encuentran creados en esta clase
 */
package com.sigeres.mensajesistema;

public class MensajeSistema {

    private String confimarIngreso = "Bienvenido ";
    private String loginError = "Login Invalido! ";
    private String reintento = "Intente nuevamente! ";
    private String creacion = "Registro  creado ";
    private String creacionNo = "Registro no creado ";
    private String errorCreacionCodigoDuplicado = "El Codigo Ingresado ya existe ";
    private String claveCambio = "Calve cambiada ";
    private String errorClaveCambio = "Clave no cambiada ";
    private String codigosDiferentes = "Los valores ingresados no son iguales ";
    private String registroActualizado = "Actualización Completada ";
    private String registroNoActualizado = "Actualizción no realizada ";
    private String confirmacionoperacion ="Operación realizada exitosamente";
    private String fallaoperacion ="Operación no realizada";
    private String mensajesistema ="";
    private String operacioneliminar="Inactivar";
    private String creacionTipoUsuario = "Tipo Usuario creado ";
    private String creacionTipoUsuarioNo = "Tipo Usuairo no creado ";

    public String getCreacionTipoUsuario() {
        return creacionTipoUsuario;
    }

    public String getCreacionTipoUsuarioNo() {
        return creacionTipoUsuarioNo;
    }
    
    
    public String getFallaoperacion() {
        return fallaoperacion;
    }

    public String getOperacioneliminar() {
        return operacioneliminar;
    }
    
    public void setMensajesistema(String mensajesistema) {
        this.mensajesistema = mensajesistema;
    }

    public String getConfirmacionoperacion() {
        return confirmacionoperacion;
    }

    public String getMensajesistema() {
        return mensajesistema;
    }

    public String getRegistroActualizado() {
        return registroActualizado;
    }

    public String getRegistroNoActualizado() {
        return registroNoActualizado;
    }

    public String getClaveCambio() {
        return claveCambio;
    }

    public String getErrorClaveCambio() {
        return errorClaveCambio;
    }

    public String getCodigosDiferentes() {
        return codigosDiferentes;
    }

    public String getConfimarIngreso() {
        return confimarIngreso;
    }

    public String getLoginError() {
        return loginError;
    }

    public String getReintento() {
        return reintento;
    }

    public String getCreacion() {
        return creacion;
    }

    public String getCreacionNo() {
        return creacionNo;
    }

    public String getErrorCreacionCodigoDuplicado() {
        return errorCreacionCodigoDuplicado;
    }
}
