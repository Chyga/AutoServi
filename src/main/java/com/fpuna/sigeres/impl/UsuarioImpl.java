/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.UsuarioDAO;
import com.fpuna.sigeres.modelo.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
public class UsuarioImpl implements UsuarioDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Usuarios add(Usuarios entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Usuarios findByUsuarioClave(String usuario, String clave) {

        Usuarios user;
        try {

            Query query = em.createQuery("SELECT U FROM Usuarios U WHERE U.codigo = :cod AND U.clave = :pass");
            query.setParameter("cod", usuario);
            query.setParameter("pass", clave);

            try {
                user = (Usuarios) query.getSingleResult();
                return user;
            } catch (Exception e) {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuarios edit(Usuarios entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Usuarios entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Usuarios getById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> getAll() {
        try {
            Query query = em.createQuery("SELECT u FROM Usuarios u");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> getAll(String value) {
        try {
            Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.estado = :value");
            query.setParameter("value", value);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] getImage(int _id) {
        try {
           
            Query sql = em.createQuery("SELECT u.photo FROM Usuarios u WHERE u.id = :id");
            sql.setParameter("id", _id);
            return (byte[])sql.getSingleResult();
            
        } catch (Exception e) {
            
            return null;
            
        }
    }
}
