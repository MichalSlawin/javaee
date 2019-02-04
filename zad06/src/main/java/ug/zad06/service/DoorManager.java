package ug.zad06.service;

import ug.zad06.domain.Door;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParsePosition;
import java.util.Date;
import java.util.List;

@Stateless
public class DoorManager {

    @PersistenceContext
    EntityManager em;

    public void addDoor(Door door){
        em.persist(door);
    }

    public Door getDoor(Long id){
        return em.find(Door.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Door> getAll(){
        return em.createNamedQuery("door.getAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Door> findByExterior(boolean exterior){
        return em.createNamedQuery("door.findByExterior").setParameter("exterior", exterior).getResultList();
    }

    public Door updateDoor(Door door){
        return em.merge(door);
    }

    public void deleteAll(){
        em.createNamedQuery("door.deleteAll").executeUpdate();
    }

    public void deleteById(int doorId) {
        em.createNamedQuery("door.deleteById").setParameter("id", doorId).executeUpdate();
    }

    public void deleteOlder(String date) {
        em.createNamedQuery("door.deleteOlder").setParameter("productionDate", date).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getProducerNames(String name) {
        return em.createNamedQuery("door.findByProducerName").setParameter("name", name).getResultList();
    }

//    public List<Object[]> getAuthorsBooks(String firstName) {
//        return em.createNamedQuery(bookAuthor.findByAuthorFirstName).setParameter("firstName", firstName)
//          .getResultList();
//    }
}


