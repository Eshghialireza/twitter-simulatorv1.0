package domain;

import repository.base.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment extends BaseDomain<Long> {
    private String text;
    @ManyToOne
    private User user;
    @ManyToOne
    private Tweet tweet;

    public Comment() {
    }

    public Comment(String text, User user, Tweet tweet) {
        this.text = text;
        this.user = user;
        this.tweet = tweet;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
