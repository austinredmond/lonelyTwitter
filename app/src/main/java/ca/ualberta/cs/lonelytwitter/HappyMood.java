package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 * This is a child class of the mood class.
 */
public class HappyMood extends Mood {
    /**
     * Constructor for HappyMood.
     * @param date The date that the mood is created.
     */
    public HappyMood(Date date) {
        super(date);
    }

    /**
     * Constructor for HappyMood
     */
    public HappyMood() {
        super();
    }

    /**
     * Gets the description of the mood.
     * @return A string which describes the mood.
     */
    @Override
    public String getDescription() {
        return ":)";
    }
}
