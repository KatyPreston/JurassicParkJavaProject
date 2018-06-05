package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.Paddocks.Paddock;

public class Mosasaurus extends Dinosaur implements ISwim {
    private int rampagePower;

    public Mosasaurus(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
        this.rampagePower = 20;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }

    public String rampage(Paddock paddock) {
        if (this.getHungerLevel() >= 6) {
            paddock.dinosaurRampage(this);
            return "Blop Bubble Splash";
        } else
            return "Gurgle";
    }
}
