/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import model.ListItem;

public class ListItemHelper {

    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DreamCarDesigner");

    // Other methods...

    public void insertItem(ListItem li) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(li);
        em.getTransaction().commit();
        em.close();
    }

    public List<ListItem> showAllCars() {
        EntityManager em = emfactory.createEntityManager();
        List<ListItem> allCars = em.createQuery("SELECT c FROM ListItem c", ListItem.class).getResultList();
        em.close();
        return allCars;
    }

    public void deleteItem(ListItem toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li WHERE li.id = :selectedId", ListItem.class);

        typedQuery.setParameter("selectedId", toDelete.getId());
        typedQuery.setMaxResults(1);

        ListItem result = typedQuery.getSingleResult();

        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public ListItem searchForItemById(int idToEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        ListItem found = em.find(ListItem.class, idToEdit);
        em.close();
        return found;
    }

    public List<ListItem> searchForItemByMake(String make) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.make = :selectedMake", ListItem.class);
        typedQuery.setParameter("selectedMake", make);
        List<ListItem> foundItems = typedQuery.getResultList();
        em.close();
        return foundItems;
    }

    public List<ListItem> searchForItemByModel(String model) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.model = :selectedModel", ListItem.class);
        typedQuery.setParameter("selectedModel", model);
        List<ListItem> foundItems = typedQuery.getResultList();
        em.close();
        return foundItems;
    }

    public List<ListItem> searchForItemByColor(String color) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.color = :selectedColor", ListItem.class);
        typedQuery.setParameter("selectedColor", color);
        List<ListItem> foundItems = typedQuery.getResultList();
        em.close();
        return foundItems;
    }

    public List<ListItem> searchForItemByCustomModifications(String customModifications) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.customModifications = :selectedCustomModifications", ListItem.class);
        typedQuery.setParameter("selectedCustomModifications", customModifications);
        List<ListItem> foundItems = typedQuery.getResultList();
        em.close();
        return foundItems;
    }

    public void updateItem(ListItem toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }
}