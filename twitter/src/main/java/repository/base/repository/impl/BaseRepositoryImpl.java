package repository.base.repository.impl;

import repository.base.BaseDomain;
import repository.base.repository.BaseRepository;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseDomain<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    private final Class<E> getClass;

    protected abstract Class<E> getEntityClass();

    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
        this.getClass = getEntityClass();
    }

    private final EntityManager em;

    @Override
    public E save(E e) {
        if (e.getId() == null) {
             em.persist(e);
        } else {
           e= em.merge(e);
        }
        return e;
    }

    @Override
    public void delete(E e) {
        em.remove(e);
    }

    @Override
    public E findById(ID id) {
        return em.find(getClass, id);
    }

    @Override
    public void deleteByID(ID id) {
        E e = findById(id);
        delete(e);
    }


    @Override
    public List<E> findAll() {
        return em.createQuery("select e from " + getClass.getSimpleName() + " e", getClass).getResultList();
    }


    @Override
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        em.getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        em.getTransaction().rollback();
    }
}
