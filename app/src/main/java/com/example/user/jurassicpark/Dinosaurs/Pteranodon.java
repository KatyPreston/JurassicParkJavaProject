package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;

public class Pteranodon extends Dinosaur implements IFly{

    public Pteranodon(FeedType feedType, String type, String name){
        super(feedType, type, name);
    }
}
