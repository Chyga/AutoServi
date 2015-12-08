package com.fpuna.sigeres.impl;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.dao.DepartamentoDAO;
import com.fpuna.sigeres.modelo.Ciudades;
import com.fpuna.sigeres.modelo.Departamentos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DepartamentoImpl implements DepartamentoDAO {

    EntityManager em = DaoFactory.getEmDAO();

    @Override
    public Departamentos add(Departamentos entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Departamentos edit(Departamentos entity) {
        try {
            em.merge(entity);
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(Departamentos entity) {
        try {
            entity.setEstado("INACTIVO");
            em.merge(entity);
        } catch (Exception ex) {

        }
    }

    @Override
    public Departamentos getById(Integer key) {
        Departamentos retorno = null;
        try {
            retorno = em.find(Departamentos.class, key);
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Departamentos> getAll() {
        List<Departamentos> resultList = em.createNamedQuery("Departamentos.findAll").getResultList();
        return resultList;
    }

    @Override
    public List<Departamentos> getAll(String value) {
        List<Departamentos> resultList = em.createNamedQuery("Departamentos.findByEstado").setParameter("estado", value).getResultList();
        return resultList;
    }

    @Override
    public List<Departamentos> getAll(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudades> cityById(Departamentos _id) {
        Query sql = em.createQuery("SELECT c FROM Ciudades c WHERE c.idDepartamento = :id");
        sql.setParameter("id", _id);
        System.out.println("---> " + _id.getDescripcion());
        return sql.getResultList();
    }
    
}
