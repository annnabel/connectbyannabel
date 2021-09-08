package com.example.annabels_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.annabels_app.converse.CategoryRecycler;
import com.example.annabels_app.converse.ConverseCategories;
import com.example.annabels_app.converse.ConverseLevels;
import com.example.annabels_app.converse.ConverseQuestions;
import com.example.annabels_app.drink.DrinkRecycler;
import com.example.annabels_app.drink.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ImageButton drinkButton, converseButton;
    private static ArrayList categoryBank, drinkQuestionBank;
    private static ArrayList questionBank;
    private static ArrayList levelBank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        importData();

        drinkButton = findViewById(R.id.drinkButton);
        converseButton = findViewById(R.id.converseButton);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinkRecycler.class);
                startActivity(intent);
            }
        });
        converseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryRecycler.class);
                startActivity(intent);
            }
        });
    }

    public void importData() {
        InputStream questions = getResources().openRawResource(R.raw.converse_questions);
        CSVFile questionsCSV = new CSVFile(questions);
        InputStream levels = getResources().openRawResource(R.raw.converse_levels);
        CSVFile levelsCSV = new CSVFile(levels);
        InputStream categories = getResources().openRawResource(R.raw.converse_categories);
        CSVFile categoriesCSV = new CSVFile(categories);
        InputStream drink = getResources().openRawResource(R.raw.drink_questions);
        CSVFile drinksCSV = new CSVFile(drink);
        try {
            questionBank = questionsCSV.readQuestions();
            categoryBank= categoriesCSV.readCategories();
            levelBank = levelsCSV.readLevels();
            drinkQuestionBank = drinksCSV.readDrinkQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<ConverseCategories> getCategories() {
        return categoryBank;
    }

    public static ArrayList<Question> getQuestions(int categoryNumber, int level) {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<ConverseQuestions> allQuestions = questionBank;
        for (int i = 0; i < allQuestions.size(); i++) {
            if ((allQuestions.get(i).getCategoryNumber() == categoryNumber) && (allQuestions.get(i).getLevel() == level)) {
                Question currentQuestion = new Question();
                currentQuestion.setCategoryNumber(allQuestions.get(i).getCategoryNumber());
                currentQuestion.setQuestion(allQuestions.get(i).getQuestion());
                questions.add(currentQuestion);
                Log.d("MainActivity" ,"Question: " + questions.get(questions.size()-1).getQuestion());
            }
        }
        return questions;
    }

    public static ArrayList<ConverseLevels> getLevels(int category) {
        ArrayList<ConverseLevels> levels = new ArrayList<>();
        ArrayList<ConverseLevels> allLevels = levelBank;
        for (int i = 0; i < allLevels.size(); i++) {
            if ((allLevels.get(i).getCategoryNumber() == category)) {
                levels.add(allLevels.get(i));
                Log.d("MainActivity" ,"levels: " + levels.get(levels.size()-1).getLevelName());
            }
        }
        return levels;
    }

    public static ArrayList<Question> getDrinkQuestions(int category) {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Question> allQuestions = drinkQuestionBank;
        for (int i = 0; i < allQuestions.size(); i++) {
            if ((allQuestions.get(i).getCategoryNumber() == category)) {
                questions.add(allQuestions.get(i));
                Log.d("MainActivity" ,"Questions: " + questions.get(questions.size()-1).getQuestion());
            }
        }
        return questions;
    }

    public static ArrayList<Question> getDrinkCategories() {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Question> allQuestions = drinkQuestionBank;
        int j = 0;
        for (int i = 0; i < allQuestions.size(); i++) {
            if ((allQuestions.get(i).getCategoryNumber() != j)) {
                questions.add(allQuestions.get(i));
                j++;
                Log.d("MainActivity" ,"Questions: " + questions.get(questions.size()-1).getQuestion());
            }
        }
        return questions;
    }
}
