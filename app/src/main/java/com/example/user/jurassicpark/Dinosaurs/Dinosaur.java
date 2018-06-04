package com.example.user.jurassicpark.Dinosaurs;

public class Dinosaur {
    private FeedType feedType;
    private String type;
    private String name;
    private int hungerLevel;

    public Dinosaur(FeedType feedType, String type, String name, int hungerLevel){
        this.feedType = feedType;
        this.type = type;
        this.name = name;
        this.hungerLevel = hungerLevel;
    }

    public FeedType getFeedType(){
        return this.feedType;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public int getHungerLevel(){
        return this.hungerLevel;
    }

    public void eat(){
        this.hungerLevel = 1;
    }
}
