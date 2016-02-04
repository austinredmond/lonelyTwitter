package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 * All tweetable objects must be able to return a message and return the date
 * it was created on.
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
