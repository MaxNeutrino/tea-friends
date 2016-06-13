package org.glasma.teafriend.repository.jpa;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.model.UserComment;
import org.glasma.teafriend.repository.UserCommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserCommentRepository implements UserCommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserComment get(int id) {
        return em.find(UserComment.class, id);
    }

    @Override
    public List<UserComment> getAllByUser(int userId) {
        return em.createNamedQuery(UserComment.ALL_SORTED_BY_USER, UserComment.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<UserComment> getAllByTea(int teaId) {
        return em.createNamedQuery(UserComment.ALL_SORTED_BY_TEA, UserComment.class)
                .setParameter("teaId", teaId)
                .getResultList();
    }

    @Override
    @Transactional
    public UserComment save(UserComment comment, int userId, int teaId) {
        User userRef = em.getReference(User.class, userId);
        Tea teaRef = em.getReference(Tea.class, teaId);
        comment.setUser(userRef);
        comment.setTea(teaRef);

        if (comment.isNew()) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(UserComment.DELETE, UserComment.class)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }
}
