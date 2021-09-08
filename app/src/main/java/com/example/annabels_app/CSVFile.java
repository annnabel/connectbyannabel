package com.example.annabels_app;

import android.util.Log;

import com.example.annabels_app.converse.ConverseCategories;
import com.example.annabels_app.converse.ConverseLevels;
import com.example.annabels_app.converse.ConverseQuestions;
import com.example.annabels_app.drink.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVFile {
    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public ArrayList readQuestions() throws IOException {
        ArrayList<ConverseQuestions> questionBank = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String csvLine;

        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(",");

            ConverseQuestions currentQuestion = new ConverseQuestions();
            currentQuestion.setCategoryNumber(Integer.valueOf(row[0].trim()));
            currentQuestion.setLevel(Integer.parseInt(row[1].trim()));
            currentQuestion.setQuestion(row[2].replaceAll("/",","));

            questionBank.add(currentQuestion);
            Log.d("MainActivity" ,"Converse Question: " + currentQuestion.getQuestion());
            Log.d("MainActivity" ,"Converse Level: " + currentQuestion.getLevel());

        }
        return questionBank;
    }

    public ArrayList readCategories() throws IOException {
        ArrayList<ConverseCategories> categoryBank = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String csvLine;

        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(",");

            ConverseCategories currentCategory = new ConverseCategories();
            currentCategory.setCategoryNumber(Integer.valueOf(row[0].trim()));
            currentCategory.setCategoryName(row[1].trim());
            currentCategory.setRelationshipType(row[2]);
            currentCategory.setLevels(Integer.valueOf(row[3].trim()));

            categoryBank.add(currentCategory);
            Log.d("MainActivity" ,"Converse Category: " + currentCategory.getCategoryName());
        }
        return categoryBank;
    }

    public ArrayList readLevels() throws IOException {
        ArrayList<ConverseLevels> levelBank = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String csvLine;

        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(",");

            ConverseLevels currentLevel = new ConverseLevels();
            currentLevel.setCategoryNumber(Integer.valueOf(row[0].trim()));
            currentLevel.setLevelNumber(Integer.valueOf(row[1].trim()));
            currentLevel.setLevelName(row[2]);

            levelBank.add(currentLevel);
            Log.d("MainActivity" ,"Converse Level: " + currentLevel.getLevelName());
        }
        return levelBank;
    }

    public ArrayList readDrinkQuestions() throws IOException {
        ArrayList<Question> drinkQuestionsBank = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String csvLine;

        while ((csvLine = reader.readLine()) != null) {
            String[] row = csvLine.split(",");

            Question currentQuestion = new Question();
            currentQuestion.setCategoryNumber(Integer.valueOf(row[0].trim()));
            currentQuestion.setCategoryName(row[1].trim().replaceAll("/",","));
            currentQuestion.setQuestion(row[2].trim().replaceAll("/",",").replaceAll(";","\n\n"));

            drinkQuestionsBank.add(currentQuestion);
            Log.d("MainActivity" ,"Converse Category: " + currentQuestion.getCategoryName());
        }
        return drinkQuestionsBank;
    }

}
