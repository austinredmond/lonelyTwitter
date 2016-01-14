package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 */
public class SadMood extends Mood {
    public SadMood(Date date) {
        super(date);
    }

    public SadMood() {
        super();
    }

    @Override
    public String getDescription() {
        return " :(";
    }
}
