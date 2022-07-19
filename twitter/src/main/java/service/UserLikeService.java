package service;

import domain.Tweet;
import domain.UserLikes;
import repository.base.service.BaseService;

import java.util.List;

public interface UserLikeService extends BaseService<UserLikes,Long> {
    void likeUnlike(Tweet tweet);
}
