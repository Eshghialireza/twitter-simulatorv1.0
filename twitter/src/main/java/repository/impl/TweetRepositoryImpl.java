package repository.impl;


import domain.Tweet;
import domain.User;
import jakarta.persistence.EntityManager;
import repository.TweetRepository;
import repository.base.repository.impl.BaseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet, Long> implements TweetRepository {
    private final EntityManager em;

    public TweetRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    protected Class<Tweet> getEntityClass() {
        return Tweet.class;
    }

    @Override
    public List<Tweet> findUserTweets(User user) {
        List<Tweet> tweets = new ArrayList<>();
        try {
            tweets = em.createQuery("select t from Tweet t where t.user=:user", Tweet.class).setParameter("user", user).getResultList();
        } catch (NullPointerException nullPointerException) {
            System.out.println("there is no result to you");
        } catch (Exception exception) {
            System.out.println("there was an error with database");
        }
        return tweets;
    }
}
