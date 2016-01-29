package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 */
public class NormalTweet extends Tweet{
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    public String getMessage(){
        return this.message;
    }

    @Override
    public boolean isImportant() {
        return false;
    }

    public int compareTo(NormalTweet tweet) {
        return this.date.compareTo(tweet.getDate());
    }

}
