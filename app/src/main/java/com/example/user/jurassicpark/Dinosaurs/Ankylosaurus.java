package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Ankylosaurus extends Dinosaur implements IWalk {
    private int rampagePower;

    public Ankylosaurus(FeedType feedType, String type, String name) {
        super(feedType, type, name);
        this.rampagePower = 40;
    }

    public int getRampagePower() {
        return this.rampagePower;
    }


}