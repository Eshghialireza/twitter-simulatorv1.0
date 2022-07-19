package service.impl;

import domain.Tweet;
import domain.UserLikes;
import repository.base.service.impl.BaseServiceImpl;
import repository.impl.UserLikesRepositoryImpl;
import service.UserLikeService;
import util.ApplicationContext;
import util.CurrentUser;

import java.util.List;

public class UserLikesServiceImpl extends BaseServiceImpl<UserLikes, Long, UserLikesRepositoryImpl> implements UserLikeService {
    public UserLikesServiceImpl(UserLikesRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public void likeUnlike(Tweet tweet) {
        boolean flag = true;
        List<UserLikes> userLikes = tweet.getLikesList();
        if (userLikes != null) {
            for (UserLikes like : userLikes
            ) {
                if (like.getUser().getId() == CurrentUser.getUser().getId()) {
                    flag = false;
                    ApplicationContext.getUserLikesService().delete(like);
                    System.out.println("unliked");
                }
            }
            if(flag){
                ApplicationContext.getUserLikesService().save(new UserLikes(CurrentUser.getUser(),tweet));
                System.out.println("liked");
            }
        }
    }

}
