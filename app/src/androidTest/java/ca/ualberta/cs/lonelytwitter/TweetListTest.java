package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by aredmond on 1/28/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }


    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void addTweetTest(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        try {
            tweets.add(tweet);
            tweets.add(tweet);
        }
        catch (IllegalArgumentException e) {

        }

        fail();
    }

    public void getTweetsTest(){
        TweetList tweets = new TweetList();
        Date date1 = new Date(1999,1,1);
        Date date2 = new Date(2016,1,2);
        Tweet tweet1 = new NormalTweet("First Test Tweet", date1);
        Tweet tweet2 = new NormalTweet("Second Test Tweet", date2);

        tweets.add(tweet2);
        tweets.add(tweet1);

        assertEquals(tweets.getTweets().get(0).getDate(), date1);
        assertEquals(tweets.getTweets().get(1).getDate(), date2);

    }

    public void testRemoveTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        tweets.removeTweet(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Test Tweet 1");
        Tweet tweet2 = new NormalTweet("Test Tweet 2");
        Tweet tweet3 = new NormalTweet("Test Tweet 3");
        Tweet tweet4 = new NormalTweet("Test Tweet 4");
        Tweet tweet5 = new NormalTweet("Test Tweet 5");

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);
        tweets.addTweet(tweet4);
        tweets.addTweet(tweet5);

        assertTrue(tweets.getCount() == 5);
    }
}