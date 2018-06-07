package com.example.user.jurassicpark.Dinosaurs;


public class TRex extends Dinosaur {
    private int rampagePower;

    public TRex(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 60;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
