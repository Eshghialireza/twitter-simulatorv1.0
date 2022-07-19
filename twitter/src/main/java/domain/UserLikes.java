package domain;

import repository.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLikes extends BaseDomain<Long> {
    @ManyToOne
    private User user;
    @ManyToOne
    private Tweet tweet;

    public UserLikes() {
    }

    public UserLikes(User user, Tweet tweet) {
        this.user = user;
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
