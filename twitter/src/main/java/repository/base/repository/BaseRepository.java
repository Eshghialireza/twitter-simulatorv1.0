package repository.base.repository;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E,ID extends Serializable> {
    E save(E e);
    void deleteByID(ID id);
    void delete(E e);
    List<E> findAll();
    E findById(ID id);
    void beginTransaction();
    void commitTransaction();
    void rollbackTransaction();
}
