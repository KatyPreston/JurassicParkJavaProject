package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Brachiosaurus extends Dinosaur implements IWalk{
    private int rampagePower;

    public Brachiosaurus(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 70;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
