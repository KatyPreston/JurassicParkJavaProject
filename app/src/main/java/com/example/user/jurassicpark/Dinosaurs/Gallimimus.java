package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Paddocks.Paddock;

public class Gallimimus extends Dinosaur implements IWalk{
    private int rampagePower;

    public Gallimimus(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
        this.rampagePower = 20;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
