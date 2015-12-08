/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.services;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Depositos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DepositoServices implements Serializable {

    EntityManager em = DaoFactory.getEmDAO();

    public List<Depositos> porIdSucursal(Integer id) {
        try {
            Query q = em.createQuery("SELECT d FROM Depositos d WHERE d.idSucursal = :param");
            q.setParameter("param", id);

            return q.getResultList();
        } catch (Exception e) {
            return null;
        }

    }
}
