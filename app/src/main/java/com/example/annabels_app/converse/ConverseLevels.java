package com.example.annabels_app.converse;

public class ConverseLevels {
    private int categoryNumber, levelNumber;
    private String levelName;

    public ConverseLevels(int categoryNumber, int levelNumber, String levelName) {
        this.categoryNumber = categoryNumber;
        this.levelNumber = levelNumber;
        this.levelName = levelName;
    }

    public ConverseLevels() {

    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
