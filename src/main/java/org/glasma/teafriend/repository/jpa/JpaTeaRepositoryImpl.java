package org.glasma.teafriend.repository.jpa;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
@Transactional(readOnly = true)
public class JpaTeaRepositoryImpl implements TeaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Tea save(Tea tea) {
        if (tea.isNew()){
            em.persist(tea);
            return tea;
        } else {
            return em.merge(tea);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Tea.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Tea get(int id) {
        return em.find(Tea.class, id);
    }

    @Override
    public Collection<Tea> getByName(String name) {
        return em.createNamedQuery(Tea.BY_NAME, Tea.class).setParameter("name", name).getResultList();
    }

    @Override
    public Collection<Tea> getAll() {
        return em.createNamedQuery(Tea.ALL_SORTED, Tea.class).getResultList();
    }

    @Override
    public Collection<Tea> getByCategory(String category) {
        return em.createNamedQuery(Tea.BY_CATEGORY, Tea.class).setParameter(1, category).getResultList();
    }

    @Override
    public Collection<Tea> getByCountry(Collection<Tea> teaList, String country) {
        return em.createNamedQuery(Tea.BY_COUNTRY, Tea.class).setParameter(1, country).getResultList();
    }
}
