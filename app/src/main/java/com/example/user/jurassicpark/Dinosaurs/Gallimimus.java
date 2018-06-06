package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Gallimimus extends Dinosaur implements IWalk{
    private int rampagePower;

    public Gallimimus(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 20;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
