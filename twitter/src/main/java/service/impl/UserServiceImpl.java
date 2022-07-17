package service.impl;

import base.service.impl.BaseServiceImpl;
import domain.User;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepositoryImpl> implements UserService {
    public UserServiceImpl(UserRepositoryImpl repository) {
        super(repository);
    }

    //its just check the unique files
    @Override
    public Boolean uniqueChecker(User user) {
        Boolean flag = false;
        List<User> usersList = findAll();
        if (user.getId() != null) {
            for (int counter = 0; counter < usersList.size(); counter++) {
                if (usersList.get(counter).getId() == user.getId()) {
                    usersList.remove(counter);
                }
            }
        }

        for (int counter = 0; counter < usersList.size(); counter++) {
            if (user.getUsername().equals(usersList.get(counter).getUsername())) {
                System.out.println("username that you entered is exist");
                flag = true;
            } else if (user.getPhoneNumber().equals(usersList.get(counter).getPhoneNumber())) {
                System.out.println("phoneNumber that you entered is exist");
                flag = true;
            }
        }
        return flag;

    }

    @Override
    public User SafeSave(User user) {
        if (uniqueChecker(user) == false) {
            user = save(user);
        }
        return user;
    }
}
