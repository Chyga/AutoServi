/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.SubGrupoDAO;
import com.fpuna.sigeres.modelo.Grupos;
import com.fpuna.sigeres.modelo.SubGrupos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class SubGrupoImpl implements SubGrupoDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public SubGrupos add(SubGrupos entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public SubGrupos edit(SubGrupos entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(SubGrupos entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public SubGrupos getById(Integer key) {

        SubGrupos deposito = null;
        try {

            deposito = em.find(SubGrupos.class, key);

            return deposito;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SubGrupos> getAll() {
        try {
            List<SubGrupos> resultList = em.createNamedQuery("SubGrupos.findAll").getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SubGrupos> getAll(String value) {
        try {
            List<SubGrupos> resultList = em.createNamedQuery("SubGrupos.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SubGrupos> getAll(Object key) {
        try {
            if (key != null) {
                //puto select de mierda ya probe de mil formas-- este de abajo era el original pero da error de algo de una clase no se que
                // Grupos s = (Grupos) key;
                // List<SubGrupos> resultList = em.createNamedQuery("SubGrupos.findAllById").setParameter("estado", s).getResultList();
                Query q = em.createQuery("SELECT g FROM Grupos g WHERE g.grupo = :param");
                q.setParameter("param", key);
                return q.getResultList();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
