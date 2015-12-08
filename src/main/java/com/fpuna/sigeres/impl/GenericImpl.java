package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.GenericDAO;
import com.fpuna.sigeres.filter.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericImpl<T>{
    
    EntityManager em = EntityManagerProvider.get();
    
    public abstract Class<T> getEntityClass();
    
    public String getNombreEntity(){
        return getEntityClass().getSimpleName();
    }
    
    public T add(T entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    public T edit(T entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    public void delete(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getById(Integer id) {
       /*T entity = null;
        try {
            entity = em.find(Depositos.class, key);
            return entity;
        } catch (Exception e) {
            return null;
        }*/
        return null;
    }

    public T getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<T> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
