package ug.zad06.service;

import ug.zad06.domain.Door;
import ug.zad06.domain.Insurance;
import ug.zad06.rest.DoorRestService;

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
        Insurance insurance = em.find(Insurance.class, id);

        List<Door> doors = insurance.getDoors();
        DoorRestService.getLocksProducers(doors);

        return insurance;
    }

    @SuppressWarnings("unchecked")
    public List<Insurance> getAll(){
        List<Insurance> insurances = em.createNamedQuery("insurance.all").getResultList();

        for(Insurance insurance : insurances) {
            List<Door> doors = insurance.getDoors();
            DoorRestService.getLocksProducers(doors);
        }

        return insurances;
    }

    public void updateInsurance(Insurance insurance){
        em.merge(insurance);
    }

    public void clearInsurances() {
        em.createNamedQuery("insurance.deleteAll").executeUpdate();
    }

    public void deleteById(long id) {
        em.createNamedQuery("insurance.deleteById").setParameter("id", id).executeUpdate();
    }
}
