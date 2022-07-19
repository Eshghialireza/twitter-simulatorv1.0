package repository;

import domain.Tweet;
import repository.base.repository.BaseRepository;
import domain.Comment;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment, Long> {
    List<Comment> findCurrentUserComments(Tweet tweet);
    List<Comment> findCurrentTweetComments(Tweet tweet);
}
