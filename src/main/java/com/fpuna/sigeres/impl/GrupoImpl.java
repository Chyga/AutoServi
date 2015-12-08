package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.GrupoDAO;
import com.fpuna.sigeres.modelo.Grupos;
import java.util.List;
import javax.persistence.EntityManager;

public class GrupoImpl implements GrupoDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Grupos add(Grupos entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Grupos edit(Grupos entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Grupos entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Grupos getById(Integer key) {
        Grupos retorno = null;
        try {
            retorno = em.find(Grupos.class, key);
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Grupos> getAll() {
        List<Grupos> resultList = em.createNamedQuery("Grupos.findAll").getResultList();
        return resultList;
    }

    @Override
    public List<Grupos> getAll(String value) {
        List<Grupos> resultList = em.createNamedQuery("Grupos.findByEstado").setParameter("estado", value).getResultList();
        return resultList;
    }

    @Override
    public List<Grupos> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
