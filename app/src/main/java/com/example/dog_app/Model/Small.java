package com.example.dog_app.Model;

public class Small {
    private int img;
    private int img2;
    private  String variety;
    private  String from;
    private  String body;
    private  String high;
    private  String hair;
    private  String color;
    private  String personality;
    private  String feature;
    private  String history;
    private  String support;

    public Small(int img, int img2, String variety, String from, String body, String high, String hair, String color, String personality, String feature, String history, String support) {
        this.img = img;
        this.img2 = img2;
        this.variety = variety;
        this.from = from;
        this.body = body;
        this.high = high;
        this.hair = hair;
        this.color = color;
        this.personality = personality;
        this.feature = feature;
        this.history = history;
        this.support = support;
    }

    public int getImg() {
        return img;
    }

    public int getImg2() {
        return img2;
    }

    public String getVariety() {
        return variety;
    }

    public String getFrom() {
        return from;
    }

    public String getBody() {
        return body;
    }

    public String getHigh() {
        return high;
    }

    public String getHair() {
        return hair;
    }

    public String getColor() {
        return color;
    }

    public String getPersonality() {
        return personality;
    }

    public String getFeature() {
        return feature;
    }

    public String getHistory() {
        return history;
    }

    public String getSupport() {
        return support;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setSupport(String support) {
        this.support = support;
    }
}
