package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Paddocks.Paddock;

public class Ankylosaurus extends Dinosaur implements IWalk{
    private int rampagePower;

    public Ankylosaurus(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
        this.rampagePower = 40;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }



//    public String escape(Paddock paddock){
//        while(paddock.getBoundaryHealth() > 0){
//            rampage(paddock);
//        }
//        return paddock.dinosaurEscapes(this);
//    }
}
