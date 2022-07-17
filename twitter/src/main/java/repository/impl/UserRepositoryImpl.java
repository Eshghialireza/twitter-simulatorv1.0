package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.User;
import jakarta.persistence.EntityManager;
import repository.UserRepository;

public class UserRepositoryImpl extends BaseRepositoryImpl<User,Long> implements UserRepository {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }
}
