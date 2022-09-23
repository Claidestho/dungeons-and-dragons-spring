package com.dd.dungeonsanddragons;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Veuillez remplir le nom du personnage")
    private String name;
    @NotBlank(message = "Veuillez remplir le type du personnage")
    private String type;
    @Column(name = "HEALTHPOINTS")
    @NotNull(message = "Veuillez remplir les PV du personnage")
    @Positive(message = "Les points de vie doivent être supérieurs à 0.")
    private int healthPoints;

    public Character(int id, String name, String type, int healthPoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.healthPoints = healthPoints;
    }

    public Character() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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
