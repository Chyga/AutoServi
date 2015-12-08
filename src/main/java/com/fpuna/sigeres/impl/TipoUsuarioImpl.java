package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.TipoUsuarioDAO;
import com.fpuna.sigeres.modelo.TiposUsuarios;
import java.util.List;
import javax.persistence.EntityManager;

public class TipoUsuarioImpl implements TipoUsuarioDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public TiposUsuarios add(TiposUsuarios entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public TiposUsuarios edit(TiposUsuarios entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(TiposUsuarios entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public TiposUsuarios getById(Integer key) {
        TiposUsuarios retorno = null;
        try {
            retorno = em.find(TiposUsuarios.class, key);
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TiposUsuarios> getAll() {
        List<TiposUsuarios> resultList = em.createNamedQuery("TiposUsuarios.findAll").getResultList();
        return resultList;
    }

    @Override
    public List<TiposUsuarios> getAll(String value) {
        List<TiposUsuarios> resultList = em.createNamedQuery("TiposUsuarios.findByEstado").setParameter("estado", value).getResultList();
        return resultList;
    }

    @Override
    public List<TiposUsuarios> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
