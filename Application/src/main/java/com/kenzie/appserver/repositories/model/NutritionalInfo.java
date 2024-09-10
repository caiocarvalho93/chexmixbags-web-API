package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public class NutritionalInfo {
    private int totalFat;
    private int calories;
    private int sugars;
    private int protein;

    @DynamoDBAttribute(attributeName = "TotalFat")
    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    @DynamoDBAttribute(attributeName = "Calories")
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @DynamoDBAttribute(attributeName = "Sugars")
    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    @DynamoDBAttribute(attributeName = "Protein")
    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
