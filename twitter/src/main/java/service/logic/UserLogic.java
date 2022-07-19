package service.logic;

import domain.User;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;
import util.ApplicationContext;
import util.CurrentUser;

public class UserLogic {
    public static void signUp() {
        User user = new User();
        System.out.println("enter your firstname");
        user.setFirstname(ApplicationContext.getStrScanner().nextLine());
        System.out.println("enter your lastname");
        user.setLastName(ApplicationContext.getStrScanner().nextLine());
        System.out.println("please enter your username");
        user.setUsername(ApplicationContext.getStrScanner().nextLine());
        System.out.println("please enter your phoneNumber");
        user.setPhoneNumber(ApplicationContext.getStrScanner().nextLine());
        System.out.println("please enter a password");
        user.setPassword(ApplicationContext.getStrScanner().nextLine());
        ApplicationContext.getUserService().safeSave(user);
    }

    public static void signIn() {
        System.out.println("please enter your username");
        String username=ApplicationContext.getStrScanner().nextLine();
        System.out.println("please enter your password");
        String password=ApplicationContext.getStrScanner().nextLine();
    User user=  ApplicationContext.getUserService().singIn(username,password);
    if(user!=null )
        CurrentUser.setCurrentUser(user);
    }
}
