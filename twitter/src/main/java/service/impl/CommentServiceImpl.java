package service.impl;

import domain.Comment;
import domain.Tweet;
import repository.base.service.impl.BaseServiceImpl;
import repository.impl.CommentRepositoryImpl;
import service.CommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl extends BaseServiceImpl<Comment,Long, CommentRepositoryImpl> implements CommentService {
    public CommentServiceImpl(CommentRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public List<Comment> findCurrentUserComments(Tweet tweet) {
       return repository.findCurrentUserComments(tweet);
    }

    @Override
    public List<Comment> findCurrentTweetComments(Tweet tweet) {
        List<Comment> comments=new ArrayList<>();
        try{
            comments=repository.findCurrentTweetComments(tweet);
        }catch (Exception exception){
            System.out.println("there was an error with database");
        }
        return comments;
    }
}
