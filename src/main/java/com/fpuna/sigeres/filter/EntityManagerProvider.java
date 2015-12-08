/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpuna.sigeres.filter;

import javax.persistence.EntityManager;

/**
 *
 * @author ci_vbaez
 */
public class EntityManagerProvider {
    
    private static ThreadLocal<EntityManager> holder = new ThreadLocal<>();

    private EntityManagerProvider() {
    }
    
    public static EntityManager get(){
        return holder.get();
    }
    
    public static void set(EntityManager em) {
        holder.set(em);
    }
}
