package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aredmond on 1/28/16.
 * Stores an array list of tweets. Several methods are used to add and retrieve
 * information.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Adds a tweet.
     * @param tweet A new tweet.
     */
    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    /**
     * Checks if a tweet is already in the array list.
     * @param tweet The tweet tht is compared to the already existing tweets.
     * @return If the tweet is in the array return true otherwise return false.
     */
    public boolean hasTweet(Tweet tweet){
        for (Tweet arrayTweet: tweets){
            if (arrayTweet.equals(tweet)){
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a tweet that is the same as the provided tweet from the array
     * list.
     * @param tweet The tweet that is to be removed.
     */
    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * Gets a tweet at a certain index.
     * @param index Index position.
     * @return Tweet at the index position.
     */
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    /**
     * Adds a tweet but first checks if the tweet is already in the array list.
     * @param tweet A new tweet.
     */
    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }

    }

    /**
     * Returns an array list of tweets that is sorted according to date.
     * @return
     */
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    /**
     * Removes a tweet that is the same as the provided tweet from the array
     * list.
     * @param tweet The tweet that is to be removed.
     */
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * Gets the number of tweets in the array list.
     * @return The size of the array list.
     */
    public int getCount() {
        return tweets.size();
    }
}
