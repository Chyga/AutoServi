/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.PedidoCompraDetalleDAO;
import com.fpuna.sigeres.modelo.PedidoCompraDetalle;
import com.fpuna.sigeres.modelo.PedidosCompras;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class PedidoCompraDetalleImpl implements PedidoCompraDetalleDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public PedidoCompraDetalle add(PedidoCompraDetalle entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public PedidoCompraDetalle edit(PedidoCompraDetalle entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(PedidoCompraDetalle entity) {
        try {
            em.detach(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public PedidoCompraDetalle getById(Integer key) {

        PedidoCompraDetalle deposito = null;
        try {

            deposito = em.find(PedidoCompraDetalle.class, key);

            return deposito;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PedidoCompraDetalle> getAll() {
        try {
            List<PedidoCompraDetalle> resultList = em.createNamedQuery("PedidoCompraDetalle.findAll").getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }


    public List<PedidoCompraDetalle> getAllPedidoCompraDetalleByPedido(PedidosCompras id) {
        try {
            List<PedidoCompraDetalle> resultList = em.createNamedQuery("PedidoCompraDetalle.findByPedido").setParameter("id", id).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PedidoCompraDetalle> getAll(Object key) {
        try {
            if (key != null) {
                Query q = em.createQuery("SELECT d FROM PedidoCompraDetalle d WHERE d.idSucursal = :param");
                q.setParameter("param", key);
                return q.getResultList();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PedidoCompraDetalle> getAll(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
