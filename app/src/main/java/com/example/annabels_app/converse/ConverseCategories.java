package com.example.annabels_app.converse;

public class ConverseCategories {
    private int categoryNumber, levels;
    private String categoryName, relationshipType;

    public ConverseCategories(int categoryNumber, String categoryName, String relationshipType, int levels) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
        this.relationshipType = relationshipType;
        this.levels = levels;
    }

    public ConverseCategories() {

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

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public int isLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
}
