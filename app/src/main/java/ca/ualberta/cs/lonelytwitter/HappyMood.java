package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aredmond on 1/14/16.
 */
public class HappyMood extends Mood {
    public HappyMood(Date date) {
        super(date);
    }

    public HappyMood() {
        super();
    }

    @Override
    public String getDescription() {
        return " :)";
    }
}
