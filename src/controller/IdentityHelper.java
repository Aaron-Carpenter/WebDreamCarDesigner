/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 2, 2023
 */
package controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class IdentityHelper {
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DreamCarDesigner");

    public void insertIdentity(IdentityType identity) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(identity);
        em.getTransaction().commit();
        em.close();
    }

    public <T> List<T> showAllIdentities(Class<T> identityClass) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<T> typedQuery = em.createQuery("SELECT i FROM " + identityClass.getSimpleName() + " i", identityClass);
        List<T> allIdentities = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return allIdentities;
    }
    
    public void deleteIdentityById(Class<?> identityClass, int id) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Object identity = em.find(identityClass, id);
        if (identity != null) {
            em.remove(identity);
        }
        em.getTransaction().commit();
        em.close();
    }

}
