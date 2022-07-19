package domain;

import jakarta.persistence.*;
import repository.base.BaseDomain;

import java.util.List;

@Entity
public class Tweet extends BaseDomain<Long> {
    @Column(length = 280, nullable = false)
    private String text;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "tweet")
    private List<Comment> commentsList;

    public Tweet() {
    }

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
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

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public List<UserLikes> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<UserLikes> likesList) {
        this.likesList = likesList;
    }

    @OneToMany(mappedBy = "tweet",cascade = CascadeType.REMOVE)
    private List<UserLikes> likesList;
}
