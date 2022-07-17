package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.UserLikes;
import jakarta.persistence.EntityManager;
import repository.UserLikesRepository;

public class UserLikesRepositoryImpl extends BaseRepositoryImpl<UserLikes,Long> implements UserLikesRepository {
    public UserLikesRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<UserLikes> getEntityClass() {
        return UserLikes.class;
    }
}
