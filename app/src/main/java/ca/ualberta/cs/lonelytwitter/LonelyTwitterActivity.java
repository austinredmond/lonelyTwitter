package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *The main activity for a small Twitter app to capture <br>notes and comments.
 * <p>It saves the input tweets in the form of json files</p><br>
 * A sample code is as:<br>
 *     <code>
 *         for (int i = 0; i < 10; i++) {
 *             for (j = 0; j < i; j++) {
 *                 doSomething();
 *             }
 *         }
 *     </code> <br>
 *The list of important activities in this clas are as follows: <br>
 *     <ul>
 *	       <li>item  1</li>
 *	       <li>item  2</li>
 *	       <li>item  3</li>
 *	       <li>item  4</li>
 *	   </ul>
 *	   @see NormalTweet
 *	   @see java.awt
 *	   @author aredmond
 *	   @version 2.1
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * @see Tweet
	 */

	static int MAXIMUM_TWEET_SIZE = 100;
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	private int calculateTweetSize() {
		//
		return -1;
	}

	public String removeStopWords() {
		//Do something
		return "";
	}

	/**
	 *
	 * @param text1 The text for the directory name
	 * @param text2 The file name.
	 * @param text3 The extension
	 * @param text4
	 * @return concatenation of ...
	 * @exception IllegalAccessError
	 * This happens if ...
	 * @exception
	 */
	public String doSomething(String text1, String text2, String text3, String text4) {
		//Do Something
		return "";
	}

	private void startSecondActivity(Intent intent){
		//Run the second activity
	}

	protected boolean evaluateOtherActivity(Intent intent) {
		//do something
		String expression1 = "",
				expression2 = "",
				expression3 = "",
				expression4 = "";
		int count = 0;
		String expression = doSomething(expression1, expression2,
				doSomething(expression3, expression4, expression3,
						expression4), expression1);
		for (int i = 0; i < count; i++) {
			try {
				int a = 1;
				int b = 2;
				int count2 = 0;
				if (a < b) {
					doSomething("", "", "", "");
				}
				else if (true) {
					doSomething("a", "", "", "" );
				}
			}
			catch(Exception e) {}
		}
		return true;
	}

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newestTweet = new NormalTweet(text);

				tweets.add(newestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
//				finish();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				deleteFile(FILENAME);
				tweets.clear();
				adapter.notifyDataSetChanged();
			}
		});
	}

	/**
	 * Called when the activity is started.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Is used to retrieve an array list containing tweet objects from a file using gson.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			//Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html Jan-20-2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Is used to save an array list of tweet objects to a file using gson.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}