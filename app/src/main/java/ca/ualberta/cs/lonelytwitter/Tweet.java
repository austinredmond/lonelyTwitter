package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aredmond on 1/14/16.
 */
public abstract class Tweet {
    protected String message;
    private Date date;
    protected ArrayList<Mood> moods;

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
        this.moods = new ArrayList();
    }

    public Tweet(String message){
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
        this.moods = new ArrayList<Mood>();
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) throws Exception {
        if (message.length() > 140){
            throw new TweetTooLongException();
        }

        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood){
        moods.add(mood);
    }

    public List getMoods() {
        return moods;
    }

    abstract public boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + "|" + message;
    }
}

