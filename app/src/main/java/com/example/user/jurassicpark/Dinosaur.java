package com.example.user.jurassicpark;

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
}
