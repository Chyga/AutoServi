package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.ProveedorDAO;
import com.fpuna.sigeres.modelo.Proveedores;
import java.util.List;
import javax.persistence.EntityManager;

public class ProveedorImpl implements ProveedorDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Proveedores add(Proveedores entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Proveedores edit(Proveedores entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Proveedores entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Proveedores getById(Integer key) {
        Proveedores retorno = null;
        try {
            retorno = em.find(Proveedores.class, key);
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Proveedores> getAll() {
        List<Proveedores> resultList = em.createNamedQuery("Proveedores.findAll").getResultList();
        return resultList;
    }

    @Override
    public List<Proveedores> getAll(String value) {
        List<Proveedores> resultList = em.createNamedQuery("Proveedores.findByEstado").setParameter("estado", value).getResultList();
        return resultList;
    }

    @Override
    public List<Proveedores> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
