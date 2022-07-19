package service;

import domain.Comment;
import domain.Tweet;
import repository.base.service.BaseService;

import java.util.List;

public interface CommentService extends BaseService<Comment,Long> {
    List<Comment> findCurrentUserComments(Tweet tweet);
    List<Comment> findCurrentTweetComments(Tweet tweet);
}
