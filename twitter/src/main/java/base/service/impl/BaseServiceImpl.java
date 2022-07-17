package base.service.impl;

import base.BaseDomain;
import base.repository.BaseRepository;
import base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseDomain<ID>, ID extends Serializable, R extends BaseRepository<E, ID>> implements BaseService<E, ID> {
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        try {
            repository.beginTransaction();
            e = repository.save(e);
            repository.commitTransaction();
        } catch (Exception exception) {
            System.out.println("we had a problem with database!!!");
            repository.rollbackTransaction();
        }
        return e;
    }

    @Override
    public void deleteByID(ID id) {
        try {
            repository.beginTransaction();
            repository.deleteByID(id);
            repository.commitTransaction();
        } catch (Exception exception) {
            System.out.println("cant delete right now");
            repository.rollbackTransaction();
        }

    }

    @Override
    public void delete(E e) {
        try {
            repository.beginTransaction();
            repository.delete(e);
            repository.commitTransaction();
        } catch (Exception exception) {
            System.out.println("cant delete right now");
            repository.rollbackTransaction();
        }
    }

    @Override
    public List<E> findAll() {
        try {
            return repository.findAll();
        } catch (Exception exception) {
            System.out.println("we had a problem with database!!!");
            return null;
        }
    }

    @Override
    public E findById(ID id) {
        try {
            return repository.findById(id);
        } catch (Exception exception) {
            System.out.println("we had a problem with database");
            return null;
        }
    }
}
