package util;

public class Menu {
    public static void showMenu(){
        System.out.println("""
                1--> signUp\s
                2--> signIn\s
                """);
    }
    public static void showSignInMenu(){
        System.out.println("""
                1--> edit your profile\s
                2--> add a tweet\s
                3--> see your tweets\s
                4--> explore\s
                5--> exit\s
                """);
    }

    public static void showTweetMenu() {
        System.out.println("""
                1-->Like/Unlike\s
                2-->add comment\s
                3-->see comment\s
                4-->exit\s
                """);
    }
    public static void showTweetSelection() {
        System.out.println("""
                1-->select tweet\s
                2-->back\s
                """);
    }
    public static void showUserUpdateMenu(){
        System.out.println("""
                1-->change firstname
                2-->change lastname
                3-->change username
                4-->change phoneNumber
                5-->change password
                6-->delete account
                """);
    }
    public static void showUserTweetUpdateMenu(){
        System.out.println("""
                1-->edit tweet
                2-->see comments
                3-->Like/Unlike
                4-->remove tweet
                5-->add comment
                6-->exit
                """);
    }
    public static void showUserCommentUpdateMenu(){
        System.out.println("""
                1-->edit comment
                2-->remove comment
                5-->exit
                """);
    }
}
