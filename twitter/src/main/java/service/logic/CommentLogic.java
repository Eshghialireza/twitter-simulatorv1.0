package service.logic;

import domain.Comment;
import domain.Tweet;
import service.logic.menu.MenuServices;
import util.ApplicationContext;
import util.CurrentUser;
import util.Menu;

import java.util.List;

public class CommentLogic {
    public static void addComment(Tweet tweet) {
        Comment comment = new Comment();
        comment.setUser(CurrentUser.getUser());
        comment.setTweet(tweet);
        System.out.println("please enter your comment");
        comment.setText(ApplicationContext.getStrScanner().nextLine());
        ApplicationContext.getCommentService().save(comment);
    }

    public static void seeTweetComments(Tweet tweet) {
        List<Comment> commentList = ApplicationContext.getCommentService().findCurrentTweetComments(tweet);
        if (commentList != null) {
            if (commentList.size() > 0) {
               showCommentsOnline(commentList);
            }
        }
    }

    public static void editCurrentUserComment(Tweet tweet) {
        List<Comment> commentList = ApplicationContext.getCommentService().findCurrentUserComments(tweet);
        if (commentList != null) {
            if(commentList.size()>0)
            safeCommentUpdaterCurrentUser(commentList);
            else
                System.out.println("you dont have any comments here");
        } else {
            System.out.println("you dont have any comments here");
        }

    }

    public static void showCommentsOnline(List<Comment> comments) {
        for (Comment c : comments
        ) {
            System.out.println(c.getUser().getUsername()+"\n"+"Id :"+ c.getId()+ " :\n" + c.getText() + "\n" + "----------------------------");

        }
    }

    public static void safeCommentUpdaterCurrentUser(List<Comment> comments) {
        boolean flag = false;
        boolean check = false;
        System.out.println("please enter comment id");
        String commentId = ApplicationContext.getStrScanner().nextLine();
        Comment comment = new Comment();
        for (Comment c : comments
        ) {
            if (c.getId() == Long.valueOf(commentId)) {
                check = true;
                comment = c;
            }

        }
        if (!check) {
            flag = true;
            System.out.println("enter a valid id");
        }
        while (!flag) {
            Menu.showUserCommentUpdateMenu();
            String userInput = ApplicationContext.getStrScanner().nextLine();
            switch (userInput) {
                case "1": {
                    System.out.println("enter new comment");
                    String edit = ApplicationContext.getStrScanner().nextLine();
                    comment.setText(edit);
                    ApplicationContext.getCommentService().save(comment);
                }
                case "2": {
                    ApplicationContext.getCommentService().delete(comment);
                    System.out.println("done");
                }
                case "3": {
                    flag = true;
                    System.out.println("done");
                }
            }

        }
    }
}
