package com.example.user.jurassicpark.Dinosaurs;

import java.util.Random;

public abstract class Dinosaur {
    private FeedType feedType;
    private String type;
    private String name;
    private int hungerLevel;

    public Dinosaur(FeedType feedType, String type, String name){
        this.feedType = feedType;
        this.type = type;
        this.name = name;
        Random rand = new Random();
        this.hungerLevel = rand.nextInt(10) + 1;
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
        if(this.hungerLevel < 0){
            this.hungerLevel = 0;
        }
        return this.hungerLevel;
    }

    public void eat(){
        this.hungerLevel = 1;
    }

    public abstract int getRampagePower();

    public boolean rampage(){
        if(this.hungerLevel >= 6){
            return true;
        }
        else return false;
    }
}
