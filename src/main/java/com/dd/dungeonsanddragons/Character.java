package com.dd.dungeonsanddragons;

public class Character {

    private final long id;
    private String name;
    private String type;
    private int healthPoints;

    public Character(long id, String name, String type, int healthPoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.healthPoints = healthPoints;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
