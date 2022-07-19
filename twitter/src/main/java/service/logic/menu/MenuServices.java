package service.logic.menu;

import domain.Tweet;
import domain.User;
import service.logic.CommentLogic;
import service.logic.TweetLogic;
import service.logic.UserLogic;
import util.ApplicationContext;
import util.CurrentUser;
import util.Menu;

import java.util.List;
import java.util.Random;

public class MenuServices {
    public static void realMenu() {
        boolean flag = false;
        while (!flag) {
            Menu.showMenu();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    UserLogic.signUp();
                    realMenu();
                    break;
                }
                case "2": {
                    UserLogic.signIn();
                    if (CurrentUser.getUser() != null)
                        signInMenu();
                    break;
                }
                default: {
                    System.out.println("please enter a valid input");
                    realMenu();
                    break;
                }
            }
        }
    }

    public static void signInMenu() {
        boolean flag = false;
        Menu.showSignInMenu();
        while (!flag) {
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    userUpdateMenu();
                    signInMenu();
                    break;
                }
                case "2": {
                    TweetLogic.addTweet(CurrentUser.getUser());
                    signInMenu();
                    break;
                }
                case "3": {
                    TweetLogic.showCurrentTweets();
                    signInMenu();
                    break;
                }
                case "4": {
                    TweetLogic.showAllTweets();
                    showTweetSelection();
                    signInMenu();
                    break;
                }
                case "5": {
                    flag = true;
                    CurrentUser.setUserNull();
                    System.out.println("sign out successfully!");
                    realMenu();
                    break;
                }
                default: {
                    System.out.println("please enter a valid input");
                    signInMenu();
                    break;
                }
            }
        }
    }

    public static void tweetMenu(Tweet tweet) {
        boolean flag = false;
        while (!flag) {
            TweetLogic.showFullTweet(tweet);
            Menu.showTweetMenu();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    ApplicationContext.getUserLikesService().likeUnlike(tweet);
                    break;
                }
                case "2": {
                    CommentLogic.addComment(tweet);
                    break;
                }
                case "3": {
                    CommentLogic.seeTweetComments(tweet);
                    CommentLogic.editCurrentUserComment(tweet);
                    break;
                }
                case "4": {
                    flag = true;
                    System.out.println("done!");
                    break;
                }
                default: {
                    System.out.println("please enter a valid input");
                    tweetMenu(tweet);
                    break;
                }
            }
        }
    }

    //explore tweet finder
    public static void showTweetSelection() {
        boolean flag = false;
        while (!flag) {
            Menu.showTweetSelection();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("enter tweet id");
                    String tweetId = ApplicationContext.getStrScanner().nextLine();
                    Tweet tweet = ApplicationContext.getTweetService().findById(Long.valueOf(tweetId));
                    if (tweet != null) {
                        tweetMenu(tweet);
                    } else {
                        System.out.println("entered id is incorrect");
                        showTweetSelection();
                    }
                    break;
                }
                case "2": {
                    System.out.println("have a nice time");
                    flag = true;
                    break;
                }
                default: {
                    System.out.println("please enter a valid input");
                    showTweetSelection();
                    break;
                }
            }
        }
    }

    //update user information
    public static void userUpdateMenu() {
        System.out.println(CurrentUser.getUser());
        User user = CurrentUser.getUser();
        boolean flag = false;
        while (!flag) {
            Menu.showUserUpdateMenu();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("enter new firstname");
                    user.setFirstname(ApplicationContext.getStrScanner().nextLine());
                    ApplicationContext.getUserService().safeSave(user);
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "2": {
                    System.out.println("enter new lastname");
                    user.setLastName(ApplicationContext.getStrScanner().nextLine());
                    ApplicationContext.getUserService().safeSave(user);
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "3": {
                    System.out.println("enter new username");
                    user.setUsername(ApplicationContext.getStrScanner().nextLine());
                    ApplicationContext.getUserService().safeSave(user);
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "4": {
                    System.out.println("enter new phoneNumber");
                    user.setPhoneNumber(ApplicationContext.getStrScanner().nextLine());
                    ApplicationContext.getUserService().safeSave(user);
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "5": {
                    System.out.println("enter new password");
                    user.setPassword(ApplicationContext.getStrScanner().nextLine());
                    ApplicationContext.getUserService().safeSave(user);
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "6": {
                    Random random = new Random();
                    int check = random.nextInt((9999 - 1111 + 1) + 1111);
                    System.out.println(check);
                    System.out.println("enter the validation code");
                    int proof = ApplicationContext.getIntScanner().nextInt();
                    if (proof == check) {
                        ApplicationContext.getUserService().delete(user);
                    } else {
                        System.out.println("its wrong");
                    }
                    CurrentUser.setUserNull();
                    realMenu();
                    break;
                }
                case "7": {
                    System.out.println("done");
                    flag = true;
                }
                default: {

                }
            }
        }
    }

    //admin panner tweet updater
    public static void currentTweetUpdater(List<Tweet> tweetList) {
        boolean flag = false;
        boolean ifExist = false;
        while (!flag) {
            Menu.showTweetSelection();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("enter tweet id");
                    String tweetId = ApplicationContext.getStrScanner().nextLine();

                    for (Tweet tweet : tweetList
                    ) {
                        if (tweet.getId() == Integer.parseInt(tweetId)) {
                            ifExist = true;
                            TweetLogic.showFullTweet(tweet);
                            currentTweetSelection(tweet);
                        }

                    }
                    if (!ifExist) {
                        System.out.println("enter a valid id");
                        currentTweetUpdater(tweetList);
                    }
                    break;
                }
                case "2": {
                    System.out.println("have a nice time");
                    flag = true;
                    break;
                }
                default: {
                    System.out.println("please enter a valid input");
                    showTweetSelection();
                    break;
                }
            }
        }
    }

    //this is for admin
    public static void currentTweetSelection(Tweet tweet) {
        boolean flag = false;
        while (!flag) {
            Menu.showUserTweetUpdateMenu();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("enter new text");
                    tweet.setText(ApplicationContext.getStrScanner().nextLine());
                    tweet = ApplicationContext.getTweetService().safeSave(tweet);
                    TweetLogic.showFullTweet(tweet);
                    break;
                }
                case "2": {
                    CommentLogic.seeTweetComments(tweet);
                    break;
                }
                case "3": {
                    ApplicationContext.getUserLikesService().likeUnlike(tweet);
                    break;
                }
                case "4": {
                    ApplicationContext.getTweetService().delete(tweet);
                    flag = true;
                    break;
                }
                case "5": {
                    CommentLogic.addComment(tweet);
                }
                case "6": {
                    System.out.println("done");
                    flag = true;
                    break;
                }
                default: {
                    System.out.println("enter a valid input");
                    currentTweetSelection(tweet);
                }
            }
        }
    }

}
