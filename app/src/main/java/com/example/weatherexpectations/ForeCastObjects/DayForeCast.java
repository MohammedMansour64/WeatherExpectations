package com.example.weatherexpectations.ForeCastObjects;

public class DayForeCast {
    private int imageCondition;
    private String date;
    private String TextCondition;
    private String highTemperature;
    private String lowTemperature;

    public DayForeCast(int imageCondition, String date, String textCondition, String highTemperature, String lowTemperature) {
        this.imageCondition = imageCondition;
        this.date = date;
        TextCondition = textCondition;
        this.highTemperature = highTemperature;
        this.lowTemperature = lowTemperature;
    }

    public int getImageCondition() {
        return imageCondition;
    }

    public void setImageCondition(int imageCondition) {
        this.imageCondition = imageCondition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTextCondition() {
        return TextCondition;
    }

    public void setTextCondition(String textCondition) {
        TextCondition = textCondition;
    }

    public String getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(String highTemperature) {
        this.highTemperature = highTemperature;
    }

    public String getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(String lowTemperature) {
        this.lowTemperature = lowTemperature;
    }
}
