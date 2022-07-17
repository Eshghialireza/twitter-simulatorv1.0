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
private final EntityManager em;
    public UserRepositoryImpl(EntityManager em) {
        super(em);
        this.em=em;
    }

    @Override
    public User signIn(String username, String password) {
        try{
            return em.createQuery("select u from User u where u.username=:username and u.password=:password",User.class)
                    .setParameter("username",username)
                    .setParameter("password",password).getSingleResult();
        }catch (Exception exception){
            return null;
        }

    }
}
