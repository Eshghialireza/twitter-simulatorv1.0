package service.impl;

import domain.User;
import repository.base.service.impl.BaseServiceImpl;
import domain.Tweet;
import repository.impl.TweetRepositoryImpl;
import service.TweetService;

import java.util.List;

public class TweetServiceImpl extends BaseServiceImpl<Tweet,Long, TweetRepositoryImpl> implements TweetService {
    public TweetServiceImpl(TweetRepositoryImpl repository) {
        super(repository);
    }
    @Override
    public Tweet safeSave(Tweet tweet) {
        if(tweet.getText().length()<=280){
           tweet =save(tweet);
            System.out.println("successful");
        }else {
            System.out.println("check the length of your tweet it should be less than 280 chars or tweet=280 chars");
        }
       return tweet;
    }

    @Override
    public List<Tweet> findUserTweets(User user) {
        return repository.findUserTweets(user);
    }


}
