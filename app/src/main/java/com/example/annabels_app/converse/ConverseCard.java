package com.example.annabels_app.converse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.annabels_app.R;
import com.example.annabels_app.drink.Question;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.annabels_app.MainActivity.getCategories;
import static com.example.annabels_app.MainActivity.getLevels;
import static com.example.annabels_app.MainActivity.getQuestions;
// add next level and exit
public class ConverseCard extends AppCompatActivity {
    private int categoryNumber, level, i, maxQuestions, maxLevel;
    private TextView categoryName1, levelName1, question1, questionNumber1, categoryName2, levelName2, question2, questionNumber2;
    private Button next1, next2, back1, back2;
    private Button nextLevel;
    private ArrayList<Question> questions;
    private ArrayList<ConverseLevels> levels;
    private boolean home, hasLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converse_card);

        Intent intent = getIntent();
        categoryNumber = intent.getIntExtra("Category Number", 0);
        Log.v("TAG", "Category = " + categoryNumber);


        categoryName1 = findViewById(R.id.categoryName1);
        levelName1 = findViewById(R.id.levelName1);
        question1 = findViewById(R.id.question1);
        questionNumber1 = findViewById(R.id.questionNumber1);

        categoryName2 = findViewById(R.id.categoryName2);
        levelName2 = findViewById(R.id.levelName2);
        question2 = findViewById(R.id.question2);
        questionNumber2 = findViewById(R.id.questionNumber2);

        back1 = findViewById(R.id.back1);
        back2 = findViewById(R.id.back2);
        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);

        start();

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }

    private void start() {
        i = 0;

        categoryName1.setText(getCategories().get(categoryNumber-1).getCategoryName());
        categoryName2.setText(getCategories().get(categoryNumber-1).getCategoryName());

        Intent intent = getIntent();
        level = intent.getIntExtra("Level Number", 0);
        Log.v("TAG", "Level = " + level);
        if (level != 0) {
            hasLevels = true;
            levels = getLevels(categoryNumber);
            maxLevel = levels.size();
            String levelName = intent.getStringExtra("Level Name");
            levelName1.setText(levelName);
            levelName2.setText(levelName);
        } else {
            hasLevels = false;
            maxLevel = 0;
            levelName1.setText("");
            levelName2.setText("");
        }
        questions = getQuestions(categoryNumber, level);
        maxQuestions = questions.size();
        Log.v("Shit","number of questions"+maxQuestions);

        if (categoryNumber != 12) {
            Collections.shuffle(questions);
        }
        updateText();
    }

    private void updateText() {
        question1.setText(questions.get(i).getQuestion());
        question2.setText(questions.get(i).getQuestion());
        questionNumber1.setText("Question " + (i + 1) + " of " + maxQuestions);
        questionNumber2.setText("Question " + (i + 1) + " of " + maxQuestions);
        next1.setEnabled(true);
        next2.setEnabled(true);
        back1.setEnabled(true);
        back2.setEnabled(true);
        if (i + 1 == maxQuestions) {
            next1.setEnabled(false);
            next2.setEnabled(false);
        }
        if ((i + 1 == 1)){
            back1.setEnabled(false);
            back2.setEnabled(false);
        }
    }

    private void next() {
        i++;
        updateText();
    }

    private void back() {
        i--;
        updateText();
    }
}

