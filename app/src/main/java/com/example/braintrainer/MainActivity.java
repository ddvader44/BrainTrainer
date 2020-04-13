package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button gobutton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;
    TextView result;
    TextView score;
    TextView sum;
    TextView timer;
    int scores=0;
    int numberOfQuestions= 0 ;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagain;
    ConstraintLayout gamelayout;
    public void playAgain(View view)
    {
        scores = 0;
        numberOfQuestions=0;
        timer.setText("30s");
        score.setText(Integer.toString(scores) + "/" +Integer.toString(numberOfQuestions));
        result.setText("");
        nextq();
        playagain.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,2000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                result.setText("Done!");
                playagain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void chooseAnswer(View view)
    {
        if(Integer.toString(locationofcorrectanswer).equals(view.getTag().toString()))
        {
            result.setText("Correct !");
            scores++ ;
        } else
        {
            result.setText("Wrong :(");
        }
        numberOfQuestions++ ;
        score.setText(Integer.toString(scores) + "/" +Integer.toString(numberOfQuestions));
        nextq();
    }
    public void go(View view)
    {
        gobutton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.textView));

    }
    public void nextq()
    {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        locationofcorrectanswer = rand.nextInt(4);
        answers.clear();
        sum.setText(Integer.toString(a)+ "+" + Integer.toString(b));
        for(int i=0;i<4;i++)
        {
            if(i==locationofcorrectanswer)
            {
                answers.add(a+b);
            } else
            {
                int wrong = rand.nextInt(41);
                while(wrong == a+b)
                {
                    answers.add(rand.nextInt(41));
                }
                answers.add(wrong);
            }

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gobutton = findViewById(R.id.start);
        sum = findViewById(R.id.textView3);
        button0 = findViewById(R.id.button21);
        button1 = findViewById(R.id.button22);
        button2 = findViewById(R.id.button23);
        button3 = findViewById(R.id.button24);
        playagain = findViewById(R.id.playAgainButton);
        result = findViewById(R.id.textView4);
        score = findViewById(R.id.textView2);
        timer = findViewById(R.id.textView);
        gamelayout = findViewById(R.id.gameLayout);
        playAgain(findViewById(R.id.textView));
        gobutton.setVisibility(View.VISIBLE);
        gamelayout.setVisibility(View.INVISIBLE);
    }
}
