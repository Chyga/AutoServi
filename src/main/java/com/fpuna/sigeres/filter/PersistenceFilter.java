/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.filter;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author ci_vbaez
 */
public class PersistenceFilter implements Filter {

    private EntityManagerFactory factory;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        factory = Persistence.createEntityManagerFactory("SiGeResPersistence");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        EntityManager em = factory.createEntityManager();
        EntityManagerProvider.set(em);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            chain.doFilter(request, response);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        factory.close();
    }

}
