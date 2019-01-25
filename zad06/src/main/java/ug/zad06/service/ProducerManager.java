package ug.zad06.service;

import ug.zad06.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProducerManager {
    @PersistenceContext
    EntityManager em;

    public void addproducer(Producer producer){
        em.persist(producer);
    }

    public Producer getproducer(Long id){
        return em.find(Producer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAll(){
        return em.createNamedQuery("producer.getAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public Producer findByName(String name){
        return (Producer) em.createNamedQuery("producer.findByName").setParameter("name", name).getSingleResult();
    }

    public Producer updateproducer(Producer producer){
        return em.merge(producer);
    }

    public void deleteAll(){
        em.createNamedQuery("producer.deleteAll").executeUpdate();
    }
}
