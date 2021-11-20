package com.demomaster.sqlDatabase;

import android.graphics.Bitmap;

public class ModelClass {

    private String id;
    private String name;
    private String surname;
    private String marks;
    private Bitmap image;

    public ModelClass(String name, String surname, String marks, Bitmap image) {
        this.name = name;
        this.surname = surname;
        this.marks = marks;
        this.image = image;
    }

    public ModelClass(String id, String name, String surname, String marks, Bitmap image) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.marks = marks;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
