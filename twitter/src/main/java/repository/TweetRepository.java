package repository;

import domain.User;
import repository.base.repository.BaseRepository;
import domain.Tweet;

import java.util.List;

public interface TweetRepository extends BaseRepository<Tweet,Long> {
    List<Tweet> findUserTweets(User user);
}
