package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;

public class Pteranodon extends Dinosaur implements IFly{
    private int rampagePower;

    public Pteranodon(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 50;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
