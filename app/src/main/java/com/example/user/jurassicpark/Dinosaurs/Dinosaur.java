package com.example.user.jurassicpark.Dinosaurs;

public class Dinosaur {
    private FeedType feedType;
    private String type;
    private String name;

    public Dinosaur(FeedType feedType, String type, String name){
        this.feedType = feedType;
        this.type = type;
        this.name = name;
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

    public String eat(){
        return "Mmmm";
    }
}
