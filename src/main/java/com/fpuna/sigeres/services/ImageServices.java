/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.services;

import com.fpuna.sigeres.dao.DaoFactory;
import java.io.Serializable;

public class ImageServices implements Serializable {

   public byte[] imagenUser(int _id){
       return DaoFactory.getUsuarioDAO().getImage(_id);
   }
}
