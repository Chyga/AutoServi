/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.ArticuloDAO;
import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.Grupos;
import com.fpuna.sigeres.modelo.Marcas;
import com.fpuna.sigeres.modelo.Proveedores;
import com.fpuna.sigeres.modelo.SubGrupos;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Christian
 */
public class ArticuloImpl implements ArticuloDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Articulos add(Articulos entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Articulos edit(Articulos entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Articulos entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Articulos getById(Integer key) {

        Articulos articulo = null;
        try {

            articulo = em.find(Articulos.class, key);

            return articulo;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Articulos> getAll() {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findAll").getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Articulos> getAll(String value) {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Articulos> getAllArticuloByProveedor(Proveedores id) {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findByProveedor").setParameter("id", id).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Articulos> getAllArticuloByMarca(Marcas id) {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findByMarca").setParameter("id", id).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Articulos> getAllArticuloByGrupo(Grupos id) {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findByProveedor").setParameter("id", id).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Articulos> getAllArticuloBySubGrupo(SubGrupos id) {
        try {
            List<Articulos> resultList = em.createNamedQuery("Articulos.findBySubGrupo").setParameter("id", id).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Articulos> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
