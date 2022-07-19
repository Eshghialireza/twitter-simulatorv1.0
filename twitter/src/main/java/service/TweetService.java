package service;

import domain.User;
import repository.base.service.BaseService;
import domain.Tweet;

import java.util.List;

public interface TweetService extends BaseService<Tweet, Long> {
    Tweet safeSave(Tweet tweet);

    List<Tweet> findUserTweets(User user);

}
