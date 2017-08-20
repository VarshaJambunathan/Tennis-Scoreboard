package com.example.tennisscoreboard;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    //Declaring the views
    TextView mScoreA, mScoreB, mTextA, mTextB;
    String sScoreA, sScoreB;
    Button mResetScore, mWinner;
    FloatingActionButton mUserA, mUserB;
    int scoreA = 0, scoreB = 0;
    ImageView mSetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mTextA = (TextView)findViewById(R.id.text_a);
        mTextB = (TextView)findViewById(R.id.text_b);
        mScoreA = (TextView) findViewById(R.id.score_a);
        mScoreB = (TextView) findViewById(R.id.score_b);
        mUserA = (FloatingActionButton)findViewById(R.id.inc_a);
        mUserB = (FloatingActionButton)findViewById(R.id.inc_b);
        mResetScore = (Button)findViewById(R.id.reset_score);
        mWinner = (Button)findViewById(R.id.winner);
        mSetImage = (ImageView)findViewById(R.id.imageContainer);

        mUserA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA++;
                sScoreA = String.valueOf(scoreA);
                mScoreA.setText(sScoreA);
            }
        });

        mUserB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreB++;
                sScoreB = String.valueOf(scoreB);
                mScoreB.setText(sScoreB);
            }
        });

        mResetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA = 0;
                scoreB = 0;

                sScoreA = String.valueOf(scoreA);
                mScoreA.setText(sScoreA);
                mTextA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.skyblue));

                sScoreB = String.valueOf(scoreB);
                mScoreB.setText(sScoreB);
                mTextB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.skyblue));
            }
        });

        mWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetImage.setImageResource(R.drawable.trophy);
                mTextA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.skyblue));
                mTextB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.skyblue));

                if (scoreA > scoreB) {
                    Toast.makeText(ScoreActivity.this, "Player A wins!", Toast.LENGTH_SHORT).show();
                    mTextA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightorange));
                } else {
                    Toast.makeText(ScoreActivity.this, "Player B wins!", Toast.LENGTH_SHORT).show();
                    mTextB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightorange));
                }
            }
        });

        mSetImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent next = new Intent(ScoreActivity.this, LearningIntents.class);
                startActivity(next);
                return true;
            }
        });

    }
}
