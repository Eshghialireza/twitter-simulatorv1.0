package service.impl;

import repository.base.service.impl.BaseServiceImpl;
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
        boolean flag = false;
        List<User> usersList = findAll();
        if (user.getId() != null) {
            for (int counter = 0; counter < usersList.size(); counter++) {
                if (usersList.get(counter).getId() == user.getId()) {
                    usersList.remove(counter);
                }
            }
        }

        for (User value : usersList) {
            if (user.getUsername().equals(value.getUsername())) {
                System.out.println("username that you entered is exist");
                flag = true;
            } else if (user.getPhoneNumber().equals(value.getPhoneNumber())) {
                System.out.println("phoneNumber that you entered is exist");
                flag = true;
            }
        }
        return flag;

    }

    @Override
    public User safeSave(User user) {
        if (!uniqueChecker(user)) {
            user = save(user);
            System.out.println("successfully signUp");
        }
        return user;
    }

    @Override
    public User singIn(String username, String password) {
       User user=repository.signIn(username,password);
       if(user==null){
           System.out.println("username or password is wrong");
           return null;
       }
       return user;
    }
}
