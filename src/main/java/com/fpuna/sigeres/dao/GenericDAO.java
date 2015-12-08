/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpuna.sigeres.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ci_vbaez
 * @param <T>
 */
public interface GenericDAO <T extends Serializable>{
    
    T add (T entity);
    T edit (T entity);
    void delete(T entity);
    T getById(Integer key);
    List<T> getAll();
    List<T> getAll(Object key);
    List<T> getAll(String value);
}
