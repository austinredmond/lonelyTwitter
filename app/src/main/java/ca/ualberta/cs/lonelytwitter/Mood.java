package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 * This is the mood abstract class.
 */
public abstract class Mood {
    private Date date;

    /**
     * The constructor for the mood object.
     * @param date The date that the mood object is created.
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Another constructor for the mood object.
     * When no date is provided by the user, the date is set as the system time.
     */
    public Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Return the date of the object.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the object.
     * @param date A new date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the description of the mood.
     * @return The description.
     */
    abstract public String getDescription();
}
