package com.example.dog_app.Model;

public class Nofood {
    String name;
    String because;
    int image;

    public Nofood(String name, int image,String  because) {
        this.name = name;
        this.image = image;
        this.because = because;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getBecause() {
        return because;
    }

    public void setBecause(String because) {
        this.because = because;
    }
}
