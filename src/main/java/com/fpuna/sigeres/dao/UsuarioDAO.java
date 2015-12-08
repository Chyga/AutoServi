/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpuna.sigeres.dao;

import com.fpuna.sigeres.modelo.Usuarios;

/**
 *
 * @author ci_vbaez
 */
public interface UsuarioDAO extends GenericDAO<Usuarios>{
    public Usuarios findByUsuarioClave(String usuario, String clave);
    public byte[] getImage(int _id);
    
}
