/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.PedidoCompraDAO;
import com.fpuna.sigeres.modelo.PedidosCompras;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class PedidoCompraImpl implements PedidoCompraDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public PedidosCompras add(PedidosCompras entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public PedidosCompras edit(PedidosCompras entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(PedidosCompras entity) {
        try {
            em.detach(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public PedidosCompras getById(Integer key) {

        PedidosCompras deposito = null;
        try {

            deposito = em.find(PedidosCompras.class, key);

            return deposito;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PedidosCompras> getAll() {
        List<PedidosCompras> list;
        try {
            list = em.createNamedQuery("PedidosCompras.findAll").getResultList();
        } catch (Exception e) {
            return null;
        }
        return list;
    }

    @Override
    public List<PedidosCompras> getAll(String value) {
        try {
            List<PedidosCompras> resultList = em.createNamedQuery("PedidosCompras.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PedidosCompras> getAll(Object key) {
        try {
            if (key != null) {
                //puto select de mierda ya probe de mil formas-- este de abajo era el original pero da error de algo de una clase no se que
                // List<PedidosCompras> resultList = em.createNamedQuery("PedidosCompras.findAllById").setParameter("estado", value).getResultList();
                //Sucursales s = (Sucursales)key;

                Query q = em.createQuery("SELECT d FROM PedidosCompras d WHERE d.idSucursal = :param");
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
