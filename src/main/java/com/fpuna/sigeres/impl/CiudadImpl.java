/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.CiudadDAO;
import com.fpuna.sigeres.modelo.Ciudades;
import com.fpuna.sigeres.modelo.Departamentos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class CiudadImpl implements CiudadDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Ciudades add(Ciudades entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Ciudades edit(Ciudades entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Ciudades entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Ciudades getById(Integer key) {

        Ciudades deposito = null;
        try {

            deposito = em.find(Ciudades.class, key);

            return deposito;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Ciudades> getAll() {
        try {
            List<Ciudades> resultList = em.createNamedQuery("Ciudades.findAll").getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Ciudades> getAll(String value) {
        try {
            List<Ciudades> resultList = em.createNamedQuery("Ciudades.findByEstado").setParameter("estado", value).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<Ciudades> getAll(Object key) {
     
        try{
            key = (Departamentos) key;
            List<Ciudades> resultList = em.createNamedQuery("Ciudades.findByDepartamento").setParameter("id", key).getResultList();
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

}
