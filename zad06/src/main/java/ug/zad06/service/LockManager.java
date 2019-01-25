package ug.zad06.service;

import ug.zad06.domain.Lock;
import ug.zad06.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class LockManager {
    @PersistenceContext
    EntityManager em;

    public void addLock(Lock lock) {
        em.persist(lock);
    }

    public Lock findLock(Long id) {
        return em.find(Lock.class, id);
    }

    public List<Lock> getAll() {
//        return em.createNamedQuery("lock.getAll").getResultList();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Lock> criteriaQuery = criteriaBuilder.createQuery(Lock.class);
        Root<Lock> root = criteriaQuery.from(Lock.class);

        CriteriaQuery<Lock> select = criteriaQuery.select(root);
        TypedQuery<Lock> typedQuery = em.createQuery(select);

        List<Lock> resultList = typedQuery.getResultList();

        for(Lock lock : resultList) {
            System.out.println(getLockProducer(lock.getId()));
        }

        return resultList;
    }

    public Producer getLockProducer(Long id) {
        Lock retrieved = findLock(id);

        return retrieved.getProducer();
    }
}
