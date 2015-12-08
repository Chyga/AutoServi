/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.ClienteDAO;
import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Clientes;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Christian
 */
public class ClienteImpl implements ClienteDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Clientes add(Clientes entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Clientes edit(Clientes entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Clientes entity) {
        try {
            entity.setCliEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Clientes getById(Integer key) {

        return null;
    }

    @Override
    public List<Clientes> getAll() {
        try {
            List<Clientes> resultList = em.createNamedQuery("Clientes.findAll").getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Clientes> getAll(String value) {
        try {
            List<Clientes> resultList = em.createNamedQuery("Clientes.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Clientes> getAll(Object key) {
        return null;
    }
}
