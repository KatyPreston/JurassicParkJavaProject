package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.Paddocks.Paddock;

public class Pteranodon extends Dinosaur implements IFly{
    private int rampagePower;

    public Pteranodon(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
        this.rampagePower = 50;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
