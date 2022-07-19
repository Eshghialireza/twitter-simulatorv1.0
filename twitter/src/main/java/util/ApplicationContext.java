package util;

import jakarta.persistence.EntityManager;
import repository.TweetRepository;
import repository.impl.CommentRepositoryImpl;
import repository.impl.TweetRepositoryImpl;
import repository.impl.UserLikesRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.impl.CommentServiceImpl;
import service.impl.TweetServiceImpl;
import service.impl.UserLikesServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class ApplicationContext {
    private static Scanner strScanner;
    private static EntityManager em = null;
    private static UserRepositoryImpl userRepository = null;
    private static UserServiceImpl userService = null;
    private static TweetRepositoryImpl tweetRepository=null;
    private static TweetServiceImpl tweetService=null;
    private static CommentRepositoryImpl commentRepository=null;
    private static CommentServiceImpl commentService=null;
    private static Scanner intScanner=null;
    private static UserLikesRepositoryImpl userLikesRepository=null;
    private static UserLikesServiceImpl userLikesService=null;

    private static UserLikesRepositoryImpl getUserLikesRepository() {
        if(userLikesRepository==null){
            userLikesRepository=new UserLikesRepositoryImpl(getEm());
        }
        return userLikesRepository;
    }

    public static UserLikesServiceImpl getUserLikesService() {
        if(userLikesService==null)
            userLikesService=new UserLikesServiceImpl(getUserLikesRepository());
        return userLikesService;
    }

    public static Scanner getIntScanner() {
        if(intScanner==null)
            intScanner=new Scanner(System.in);
        return intScanner;
    }

    private static CommentRepositoryImpl getCommentRepository() {
        if(commentRepository==null)
            commentRepository=new CommentRepositoryImpl(getEm());
        return commentRepository;
    }

    public static CommentServiceImpl getCommentService() {
        if(commentService==null)
            commentService=new CommentServiceImpl(getCommentRepository());
        return commentService;
    }

    private static TweetRepositoryImpl getTweetRepository() {
        if(tweetRepository==null)
            tweetRepository=new TweetRepositoryImpl(getEm());
        return tweetRepository;
    }

    public static TweetServiceImpl getTweetService() {
        if(tweetService==null)
            tweetService=new TweetServiceImpl(getTweetRepository());
        return tweetService;
    }

    public static UserServiceImpl getUserService() {
        if (userService == null)
            userService = new UserServiceImpl(getUserRepository());
        return userService;
    }

    private static UserRepositoryImpl getUserRepository() {
        if (userRepository == null)
            userRepository = new UserRepositoryImpl(getEm());
        return userRepository;
    }

    public static Scanner getStrScanner() {
        if (strScanner == null)
            strScanner = new Scanner(System.in);
        return strScanner;
    }

    public static EntityManager getEm() {
        if (em == null)
            em = HibernateUtil.getEm();
        return em;
    }
    private ApplicationContext(){

    }
}
