package repository.impl;

import domain.Comment;
import domain.Tweet;
import domain.User;
import jakarta.persistence.EntityManager;
import repository.CommentRepository;
import repository.base.repository.impl.BaseRepositoryImpl;
import util.CurrentUser;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment, Long> implements CommentRepository {
    private final EntityManager em;

    public CommentRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public List<Comment> findCurrentUserComments(Tweet tweet) {
        List<Comment> comments = new ArrayList<>();
        User user = CurrentUser.getUser();

        try {
            comments = em.createQuery("select c from Comment c where c.tweet=:tweet and c.user=:userClass", Comment.class)
                    .setParameter("tweet", tweet).setParameter("userClass",user).getResultList();
        } catch (NullPointerException nullPointerException) {
            System.out.println("there is no result");
        } catch (Exception exception) {
            System.out.println("there was an error in database");
        }

        return comments;
    }

    @Override
    public List<Comment> findCurrentTweetComments(Tweet tweet) {
        List<Comment> comments = new ArrayList<>();
        try {
            comments = em.createQuery("select c from Comment c where c.tweet=:tweet", Comment.class).setParameter("tweet", tweet).getResultList();
        } catch (NullPointerException nullPointerException) {
            System.out.println("there is no result");
        } catch (Exception exception) {
            System.out.println("there was an error in database");
        }

        return comments;
    }
}
