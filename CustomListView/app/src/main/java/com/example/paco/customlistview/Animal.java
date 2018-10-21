package com.example.paco.customlistview;

public class Animal {

    private int idImage;
    private String name;
    private String description;

    public Animal(String name, String description, int idImage) {
        this.name = name;
        this.description = description;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }
    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
