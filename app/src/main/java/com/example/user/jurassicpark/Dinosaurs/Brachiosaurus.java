package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Paddocks.Paddock;

public class Brachiosaurus extends Dinosaur implements IWalk{
    private int rampagePower;

    public Brachiosaurus(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
        this.rampagePower = 70;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }

    public String rampage(Paddock paddock){
        paddock.dinosaurRampage(this);
        return "Stomp Stomp";
    }
}
