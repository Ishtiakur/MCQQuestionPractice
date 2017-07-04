package com.example.ishtiak.mcqquestionpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        TextView t2=(TextView)findViewById(R.id.txt2);
        Button btnTryAgain = (Button) findViewById(R.id.tryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        String score2 = String.valueOf(score);
        t2.setText("Your Score is "+ score2 + "\n out of 5");

        //display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("Sorry you can't any answer of them");
                break;
            case 1: t.setText("you have to learn more");
                break;
            case 2: t.setText("keep learning.......");
                break;
            
            case 3:
            case 4:t.setText("Hmmmm.. maybe you have been reading a lot of Java Programming quiz");
                break;
            case 5:t.setText("Excellent You have given all right answer");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
    }

