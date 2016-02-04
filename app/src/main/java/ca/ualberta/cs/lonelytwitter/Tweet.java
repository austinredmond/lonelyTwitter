package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aredmond on 1/14/16.
 * Abstract class. This represents tweets and holds all the information needed
 * for a basic tweet object.
 */
public abstract class Tweet implements Comparable<Tweet> {
    protected String message;
    protected Date date;
    protected ArrayList<Mood> moods;

    /**
     * Constructor for the tweet object.
     * @param message The content of the tweet.
     * @param date The date that the tweet is created.
     */
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
        this.moods = new ArrayList();
    }

    /**
     * Another constructor for the tweet object.
     * When no date is provided by the user, the date is set as the system time.
     * @param message The content of the tweet.
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
        this.moods = new ArrayList<Mood>();
    }

    /**
     * Gets the date of the tweet object.
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the message.
     * @param message The new message.
     * @throws Exception The tweet must be under the 140 character limit.
     */
    public void setMessage(String message) throws Exception {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }

        this.message = message;
    }

    /**
     * Sets the message.
     * @param date The new date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Adds a mood to the tweet.
     * @param mood A new mood to be added.
     */
    public void addMood(Mood mood){
        moods.add(mood);
    }

    /**
     * Gets all the moods associated with the tweet.
     * @return An array of moods.
     */
    public List getMoods() {
        return moods;
    }

    /**
     * Abstract method which checks whether the tweet is important. Not implemented here.
     * @return
     */
    abstract public boolean isImportant();

    /**
     * Returns the message.
     * @return The message.
     */
    public String getMessage(){
        return this.message;
    }


    //took from http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date Jan-28-2016
    /**
     * Compares the date of this tweet to another tweet.
     * @param tweet
     * @return Returns the value 0 if the argument Date is equal to this Date;
     * a value less than 0 if this Date is before the Date argument;
     * and a value greater than 0 if this Date is after the Date argument.
     */
    public int compareTo(Tweet tweet) {
        return this.date.compareTo(tweet.getDate());
    }

    /**
     * A string representation of the string method. Informs the viewer of the
     * date the tweet was created on and the content of the tweet.
     * @return
     */
    @Override
    public String toString(){
        return date.toString() + "|" + message;
    }
}

