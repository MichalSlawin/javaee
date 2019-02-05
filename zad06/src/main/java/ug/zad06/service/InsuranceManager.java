package ug.zad06.service;

import ug.zad06.domain.Insurance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InsuranceManager {

    @PersistenceContext
    EntityManager em;

    public void addInsurance(Insurance insurance) {
        em.persist(insurance);
    }

    public Insurance getInsurance(Long id){
        return em.find(Insurance.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Insurance> getAll(){
        return em.createNamedQuery("insurance.all").getResultList();
    }

    public Insurance updateInsurance(Insurance insurance){
        return em.merge(insurance);
    }

    public void clearInsurances() {
        em.createNamedQuery("insurance.deleteAll").executeUpdate();
    }

    public void deleteById(long id) {
        em.createNamedQuery("insurance.deleteById").setParameter("id", id).executeUpdate();
    }
}
