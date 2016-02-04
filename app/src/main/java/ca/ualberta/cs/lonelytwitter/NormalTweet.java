package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 * A child of the abstract class Tweet. Is tweetable.
 */
public class NormalTweet extends Tweet{
    /**
     * A constructor for normal tweet.
     * @param message This is the content of the tweet.
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Another constructor for normal tweet.
     * @param message This is the content of the tweet.
     * @param date This is the date the normal tweet was created.
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Returns the message.
     * @return The message.
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Checks if the tweet is important.
     * @return False because a normal tweet is not important.
     */
    @Override
    public boolean isImportant() {
        return false;
    }

    /**
     * Compares the date of this tweet to another tweet.
     * @param tweet
     * @return Returns the value 0 if the argument Date is equal to this Date;
     * a value less than 0 if this Date is before the Date argument;
     * and a value greater than 0 if this Date is after the Date argument.
     */
    public int compareTo(NormalTweet tweet) {
        return this.date.compareTo(tweet.getDate());
    }

}
