package org.glasma.teafriend.repository.jpa;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.TeaRate;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.TeaRateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaTeaRateRepositoryImpl implements TeaRateRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public TeaRate setRate(TeaRate rate, int userId, int teaId) {
        User userRef = em.getReference(User.class, userId);
        Tea teaRef = em.getReference(Tea.class, teaId);
        rate.setUser(userRef);
        rate.setTea(teaRef);

        if (rate.isNew()) {
            em.persist(rate);
            return rate;
        } else {
            return em.merge(rate);
        }
    }

    @Override
    public TeaRate get(int userId, int teaId) {
        return em.createNamedQuery(TeaRate.GET, TeaRate.class)
                .setParameter("teaId", teaId)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public List<TeaRate> getAllByTea(int teaId) {
        return em.createNamedQuery(TeaRate.ALL_SORTED, TeaRate.class)
                .setParameter("teaId", teaId)
                .getResultList();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(TeaRate.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    @Transactional
    public boolean deleteAll(int teaId) {
        return em.createNamedQuery(TeaRate.DELETE_ALL)
                .setParameter("teaId", teaId)
                .executeUpdate() != 0;
    }
}
