package service;

import repository.base.service.BaseService;
import domain.User;

public interface UserService extends BaseService<User, Long> {
    Boolean uniqueChecker(User user);

    User safeSave(User user);

    User singIn(String username, String password);
}
