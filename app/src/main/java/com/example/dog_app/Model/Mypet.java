package com.example.dog_app.Model;

public class Mypet {
    private String postid;
    private String postimage;
    private String name;
    private String birthday;
    private String chip;
    private String allerg;
    private String med;
    private String publisher;

    public Mypet(String postid, String postimage, String name, String birthday, String chip, String allerg, String med, String publisher) {
        this.postid = postid;
        this.postimage = postimage;
        this.name = name;
        this.birthday = birthday;
        this.chip = chip;
        this.allerg = allerg;
        this.med = med;
        this.publisher = publisher;
    }
    public  Mypet() {

    }


    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage() {
        return postimage;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getAllerg() {
        return allerg;
    }

    public void setAllerg(String allerg) {
        this.allerg = allerg;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}