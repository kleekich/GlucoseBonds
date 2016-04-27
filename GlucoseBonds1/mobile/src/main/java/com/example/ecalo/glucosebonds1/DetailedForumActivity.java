package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by joel on 4/19/16.
 */
public class DetailedForumActivity extends AppCompatActivity{
    ImageButton button;
    Context context;

    public String FirstName;
    public String LastName;
    public String DayPosted;
    public String likes;
    public String question;
    public String questionDescription;
    public String numberOfComments;
    public String commentName;
    public String secondComment;
    public String  secondCommentName;
    public String firstComment;

    public TextView title;
    public TextView questionContent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_forum_details);
//        button = (ImageButton) findViewById(R.id.img_btn);
//        button.setImageResource(R.drawable.education_screen);
        title = (TextView) findViewById(R.id.title);
        questionContent = (TextView) findViewById(R.id.questionContent);

        try {
            testJSON();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void testJSON() throws JSONException {


        //This creates the new json object which represents the specific question that you want to see in
        //forum page
        JSONObject forumQuestion = new JSONObject();
        forumQuestion.put("firstName", "John");
        forumQuestion.put("lastName", "Smith");
        forumQuestion.put("dayPosted", "4/14/16");
        forumQuestion.put("likes", "6");
        forumQuestion.put("question", "What are some ways to get your child to exercise more");
        forumQuestion.put("comments", 7);
        forumQuestion.put("questionDescription", "My son is currently 10 years old, diagnosed with type 1 diabetes over a year ago. He was never an athletic child and mostly spends his time in front of the tv. I have tried to get him to go outside but can’t motivate him to exercise for long. Any thoughts?");
        //This is adding the json object in an array that we will parse through in order to get this information onto
        //the actual screen.
        JSONArray forumQuestionArray = new JSONArray();
        forumQuestionArray.put(forumQuestion);

        //you use this to extract information and population the text boxes
        JSONObject subObject = forumQuestionArray.getJSONObject(0);
        FirstName = subObject.getString("firstName");
        LastName = subObject.getString("lastName");
        DayPosted = subObject.getString("dayPosted");
        likes = subObject.getString("likes");
        question = subObject.getString("question");
        numberOfComments = subObject.getString("comments");
        questionDescription = subObject.getString("questionDescription");

        title.setText(question);
        questionContent.setText(questionDescription);
    }

}
