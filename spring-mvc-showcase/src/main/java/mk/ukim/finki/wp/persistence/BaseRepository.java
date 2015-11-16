package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.persistence.helper.PredicateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ristes on 11/16/15.
 */
@Repository
public class BaseRepository {

  @PersistenceContext
  private EntityManager em;

  public <T> T getById(Class<T> type, Long id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(type);
    final Root<T> root = cq.from(type);

    Predicate byId = cb.equal(root.get("id"), id);

    cq.where(byId);

    TypedQuery<T> query = em.createQuery(cq);

    return query.getSingleResult();
  }

  public <T> List<T> find(Class<T> type, PredicateBuilder<T> predicateBuilder) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(type);
    final Root<T> root = cq.from(type);

    if (predicateBuilder != null)
      cq.where(predicateBuilder.toPredicate(cb, cq, root));

    TypedQuery<T> query = em.createQuery(cq);

    return query.getResultList();
  }

  @Transactional
  public <T> T saveOrUpdate(T entity) {
    if (!em.contains(entity)) {
      entity = em.merge(entity);
    } else {
      em.persist(entity);
    }
    em.flush();
    return entity;
  }

  public <T> int delete(Class<T> type, Long id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaDelete<T> cd = cb.createCriteriaDelete(type);
    final Root<T> root = cd.from(type);


    CriteriaQuery<T> cq = cb.createQuery(type);
    Predicate byId = cb.equal(root.get("id"), id);
    cd.where(byId);
    int changes = em.createQuery(cd).executeUpdate();
    em.flush();
    return changes;
  }
}
