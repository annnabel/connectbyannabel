package com.example.annabels_app.drink;

public class Question {
    private int categoryNumber;
    private String categoryName;
    private String question;

    public Question() {
    }

    public Question(int categoryNumber, String categoryName, String question) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
        this.question = question;
    }
    public Question(int categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }
    public int getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
