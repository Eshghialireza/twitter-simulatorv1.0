package service.logic;

import domain.Tweet;
import domain.User;
import service.logic.menu.MenuServices;
import util.ApplicationContext;
import util.CurrentUser;
import java.util.List;

public class TweetLogic {
    public static void addTweet(User user) {
        Tweet tweet = new Tweet();
        System.out.println("please write your sweet tweet :)");
        tweet.setText(ApplicationContext.getStrScanner().nextLine());
        tweet.setUser(user);
        ApplicationContext.getTweetService().safeSave(tweet);
    }
    public static void showAllTweets(){
      List<Tweet> tweetList=  ApplicationContext.getTweetService().findAll();
      if(tweetList!=null){
          if(tweetList.size()>0){
              for (Tweet tweet:tweetList
              ) {
                  String sample;
                  if( tweet.getText().length()>15){
                      sample=tweet.getText().substring(0,14)+"...";
                  }else
                      sample=tweet.getText();
                  System.out.println( tweet.getUser().getUsername()+" \n "+
                          "tweet Id--> "+tweet.getId()+" \n "+
                          sample+" \n "+
                          "likes--> "+tweet.getLikesList().size()+"\n"+
                          "comments--> "
                          +tweet.getCommentsList().size()+"\n"
                          +"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ \n");
              }
          }else {
              System.out.println("there is no result to you");
          }

      }else{
          System.out.println("there is no result to you");
      }
    }
    public static void showCurrentTweets(){
        List<Tweet> tweets= ApplicationContext.getTweetService().findUserTweets(CurrentUser.getUser());
       if(tweets.size()>0){
           for (Tweet tweet:tweets
           ) {
               String sample;
               if( tweet.getText().length()>15){
                   sample=tweet.getText().substring(0,14)+"...";
               }else
                   sample=tweet.getText();
               System.out.println( tweet.getUser().getUsername()+" \n "+
                       "tweet Id--> "+tweet.getId()+" \n "+
                       sample+" \n "+
                       "likes--> "+tweet.getLikesList().size()+"\n"+
                       "comments--> "
                       +tweet.getCommentsList().size()+"\n"
                       +"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ \n");

           }
           MenuServices.currentTweetUpdater(tweets);
       }else{
           System.out.println("you dont have any tweets");
       }

    }
    public static void showFullTweet(Tweet tweet){
        System.out.println( tweet.getUser().getUsername()+" \n "+
                "tweet Id--> "+tweet.getId()+" \n "+
                tweet.getText()+" \n "+
                "likes--> "+tweet.getLikesList().size()+"\n"+
                "comments--> "
                +tweet.getCommentsList().size()+"\n");
    }
}
