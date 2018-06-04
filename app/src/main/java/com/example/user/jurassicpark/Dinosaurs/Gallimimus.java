package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Gallimimus extends Dinosaur implements IWalk{

    public Gallimimus(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
    }
}
