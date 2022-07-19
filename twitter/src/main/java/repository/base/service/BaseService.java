package repository.base.service;

import java.util.List;

public interface BaseService<E,ID> {
    E save(E e);
    void deleteByID(ID id);
    void delete(E e);
    List<E> findAll();
    E findById(ID id);
}
