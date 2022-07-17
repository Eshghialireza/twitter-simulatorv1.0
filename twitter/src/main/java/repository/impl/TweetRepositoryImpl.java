package repository.impl;


import base.repository.impl.BaseRepositoryImpl;
import domain.Tweet;
import jakarta.persistence.EntityManager;
import repository.TweetRepository;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet,Long> implements TweetRepository {

    public TweetRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Tweet> getEntityClass() {
        return Tweet.class;
    }
}
