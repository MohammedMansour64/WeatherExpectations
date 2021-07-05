package com.example.weatherexpectations.ForeCastObjects;

public class HourForeCast {
    private String clock;
    private int condition;
    private String temperature;

    public HourForeCast(String clock, int condition, String temperature) {
        this.clock = clock;
        this.condition = condition;
        this.temperature = temperature;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
