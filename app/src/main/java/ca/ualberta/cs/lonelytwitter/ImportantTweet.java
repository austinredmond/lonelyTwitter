package ca.ualberta.cs.lonelytwitter;

/**
 * Created by aredmond on 1/14/16.
 * A child of the abstract class Tweet. Is tweetable.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    /**
     * A constructor for important tweet.
     * @param message This is the content of the tweet.
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Checks if the tweet is important.
     * @return True because an important tweet is important.
     */
    @Override
    public boolean isImportant() {
        return true;
    }

    /**
     * Modifies the message to signify the importance of the tweet and returns it.
     * @return
     */
    public String getMessage(){
        return "Important!! " + this.message;
    }
}
