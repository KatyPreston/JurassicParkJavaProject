package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class TRex extends Dinosaur implements IWalk{
    private int rampagePower;

    public TRex(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 60;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }


}
