package com.example.annabels_app.converse;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.annabels_app.R;
import com.example.annabels_app.drink.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.annabels_app.MainActivity.getCategories;
import static com.example.annabels_app.MainActivity.getDrinkQuestions;
import static com.example.annabels_app.MainActivity.getLevels;
import static com.example.annabels_app.MainActivity.getQuestions;

public class ConverseCardSingle extends AppCompatActivity {
    private int categoryNumber, level, i, maxQuestions, maxLevel, drink;
    private TextView categoryName2, levelName2, question2, questionNumber2;
    private Button next2, back2;
    private ArrayList<Question> questions;
    private Button nextLevel;
    private CardView card;
    
    private ArrayList<ConverseLevels> levels;
    private boolean home, hasLevels;

    public ConverseCardSingle() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converse_card_single);

        Intent intent = getIntent();
        categoryNumber = intent.getIntExtra("Category Number", 0);
        drink = intent.getIntExtra("Drink", 0);

        Log.v("TAG", "Category = " + categoryNumber);

//        card.setCardBackgroundColor(color);


        categoryName2 = findViewById(R.id.categoryName2);
        levelName2 = findViewById(R.id.levelName2);
        question2 = findViewById(R.id.question2);
        questionNumber2 = findViewById(R.id.questionNumber2);
        card = findViewById(R.id.whiteCard);
        back2 = findViewById(R.id.back2);
        next2 = findViewById(R.id.next2);

        start();


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void start() {
        Intent intent = getIntent();
        level = intent.getIntExtra("Level Number", 0);
        Log.v("TAG", "Level = " + level);
        if (level != 0) {
            hasLevels = true;
            levels = getLevels(categoryNumber);
            maxLevel = levels.size();
            String levelName = intent.getStringExtra("Level Name");
            levelName2.setText(levelName);
        } else {
            hasLevels = false;
            maxLevel = 0;
            levelName2.setText("");
        }
        i = 0;
        if (drink == 0) {
            questions = getQuestions(categoryNumber, level);
            categoryName2.setText(getCategories().get(categoryNumber-1).getCategoryName());
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.pastelPink));
        } else {
            questions = getDrinkQuestions(categoryNumber);
            categoryName2.setText(questions.get(1).getCategoryName());
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));
            card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.black));
        }



        maxQuestions = questions.size();
        Log.v("Shit","number of questions"+maxQuestions);

        if (categoryNumber != 12) {
            Collections.shuffle(questions);
        }
        updateText();
    }

    private void updateText() {
        question2.setText(questions.get(i).getQuestion());
        questionNumber2.setText("Question " + (i + 1) + " of " + maxQuestions);
        next2.setEnabled(true);
        back2.setEnabled(true);
        if (i + 1 == maxQuestions) {
            next2.setEnabled(false);
        }
        if ((i + 1 == 1)){
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
