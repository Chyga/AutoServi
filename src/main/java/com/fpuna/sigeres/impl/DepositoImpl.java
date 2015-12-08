/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.DepositoDAO;
import com.fpuna.sigeres.modelo.Depositos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class DepositoImpl implements DepositoDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Depositos add(Depositos entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Depositos edit(Depositos entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Depositos entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Depositos getById(Integer key) {

        Depositos deposito = null;
        try {

            deposito = em.find(Depositos.class, key);

            return deposito;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Depositos> getAll() {
        List<Depositos> list;
        try {
            list = em.createNamedQuery("Depositos.findAll").getResultList();
        } catch (Exception e) {
            return null;
        }
        return list;
    }

    @Override
    public List<Depositos> getAll(String value) {
        try {
            List<Depositos> resultList = em.createNamedQuery("Depositos.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Depositos> getAllDepositoByIdSucursal(Integer id) {
        List<Depositos> depositoList = new ArrayList();
        try {
            Query query = em.createQuery("SELECT d FROM Depositos d WHERE d.idSucursal = :param");
            query.setParameter("param", id);

            try {
                depositoList = query.getResultList();
                return depositoList;

            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Depositos> getAll(Object key) {
        try {
            if (key != null) {
                //puto select de mierda ya probe de mil formas-- este de abajo era el original pero da error de algo de una clase no se que
                // List<Depositos> resultList = em.createNamedQuery("Depositos.findAllById").setParameter("estado", value).getResultList();
                //Sucursales s = (Sucursales)key;

                Query q = em.createQuery("SELECT d FROM Depositos d WHERE d.idSucursal = :param");
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
