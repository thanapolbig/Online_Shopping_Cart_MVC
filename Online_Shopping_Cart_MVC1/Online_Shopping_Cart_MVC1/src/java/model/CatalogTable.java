/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ASUS
 */
public class CatalogTable {
        public static Vector<Catalog> findAllDvd() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Online_Shopping_Cart_MVC1PU");
        EntityManager em = emf.createEntityManager();
        Vector<Catalog> dvdList = null;
        try {
            dvdList = (Vector<Catalog>) em.createNamedQuery("Catalog.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return dvdList;
    }
}
