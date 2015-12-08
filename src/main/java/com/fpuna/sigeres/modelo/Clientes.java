/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCliId", query = "SELECT c FROM Clientes c WHERE c.cliId = :cliId"),
    @NamedQuery(name = "Clientes.findByCliNombre", query = "SELECT c FROM Clientes c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Clientes.findByCliApellido", query = "SELECT c FROM Clientes c WHERE c.cliApellido = :cliApellido"),
    @NamedQuery(name = "Clientes.findByCliTipoPersona", query = "SELECT c FROM Clientes c WHERE c.cliTipoPersona = :cliTipoPersona"),
    @NamedQuery(name = "Clientes.findByCliEmail", query = "SELECT c FROM Clientes c WHERE c.cliEmail = :cliEmail"),
    @NamedQuery(name = "Clientes.findByCliCelular", query = "SELECT c FROM Clientes c WHERE c.cliCelular = :cliCelular"),
    @NamedQuery(name = "Clientes.findByCliTelefono", query = "SELECT c FROM Clientes c WHERE c.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Clientes.findByCliRuc", query = "SELECT c FROM Clientes c WHERE c.cliRuc = :cliRuc"),
    @NamedQuery(name = "Clientes.findByCliRazonSocial", query = "SELECT c FROM Clientes c WHERE c.cliRazonSocial = :cliRazonSocial"),
    @NamedQuery(name = "Clientes.findByCliDepartamento", query = "SELECT c FROM Clientes c WHERE c.cliDepartamento = :cliDepartamento"),
    @NamedQuery(name = "Clientes.findByCliCiudad", query = "SELECT c FROM Clientes c WHERE c.cliCiudad = :cliCiudad"),
    @NamedQuery(name = "Clientes.findByCliPais", query = "SELECT c FROM Clientes c WHERE c.cliPais = :cliPais"),
    @NamedQuery(name = "Clientes.findByCliEstado", query = "SELECT c FROM Clientes c WHERE c.cliEstado = :cliEstado"),
    @NamedQuery(name = "Clientes.findByCliCedula", query = "SELECT c FROM Clientes c WHERE c.cliCedula = :cliCedula")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLI_ID")
    private Integer cliId;
    @Size(max = 50)
    @Column(name = "CLI_NOMBRE")
    private String cliNombre;
    @Size(max = 50)
    @Column(name = "CLI_APELLIDO")
    private String cliApellido;
    @Size(max = 50)
    @Column(name = "CLI_TIPO_PERSONA")
    private String cliTipoPersona;
    @Size(max = 50)
    @Column(name = "CLI_EMAIL")
    private String cliEmail;
    @Size(max = 50)
    @Column(name = "CLI_CELULAR")
    private String cliCelular;
    @Size(max = 50)
    @Column(name = "CLI_TELEFONO")
    private String cliTelefono;
    @Size(max = 50)
    @Column(name = "CLI_RUC")
    private String cliRuc;
    @Size(max = 50)
    @Column(name = "CLI_RAZON_SOCIAL")
    private String cliRazonSocial;
    @Size(max = 50)
    @Column(name = "CLI_DEPARTAMENTO")
    private String cliDepartamento;
    @Size(max = 50)
    @Column(name = "CLI_CIUDAD")
    private String cliCiudad;
    @Size(max = 50)
    @Column(name = "CLI_PAIS")
    private String cliPais;
    @Size(max = 50)
    @Column(name = "CLI_ESTADO")
    private String cliEstado;
    @Size(max = 50)
    @Column(name = "CLI_CEDULA")
    private String cliCedula;

    public Clientes() {
    }

    public Clientes(Integer cliId) {
        this.cliId = cliId;
    }

    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliTipoPersona() {
        return cliTipoPersona;
    }

    public void setCliTipoPersona(String cliTipoPersona) {
        this.cliTipoPersona = cliTipoPersona;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliRuc() {
        return cliRuc;
    }

    public void setCliRuc(String cliRuc) {
        this.cliRuc = cliRuc;
    }

    public String getCliRazonSocial() {
        return cliRazonSocial;
    }

    public void setCliRazonSocial(String cliRazonSocial) {
        this.cliRazonSocial = cliRazonSocial;
    }

    public String getCliDepartamento() {
        return cliDepartamento;
    }

    public void setCliDepartamento(String cliDepartamento) {
        this.cliDepartamento = cliDepartamento;
    }

    public String getCliCiudad() {
        return cliCiudad;
    }

    public void setCliCiudad(String cliCiudad) {
        this.cliCiudad = cliCiudad;
    }

    public String getCliPais() {
        return cliPais;
    }

    public void setCliPais(String cliPais) {
        this.cliPais = cliPais;
    }

    public String getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpuna.sigeres.modelo.Clientes[ cliId=" + cliId + " ]";
    }
    
}
