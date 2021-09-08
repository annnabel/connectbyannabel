package com.example.annabels_app.converse;

public class ConverseQuestions {
    private int categoryNumber;
    private int level;
    private String question;

    public ConverseQuestions() {
        this.categoryNumber = categoryNumber;
        this.level = level;
        this.question = question;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(int category) {
        this.categoryNumber = category;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
