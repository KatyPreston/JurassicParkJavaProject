package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Velociraptor extends Dinosaur implements IWalk{

    public Velociraptor(FeedType feedType, String type, String name, int hungerLevel){
        super(feedType, type, name, hungerLevel);
    }
}
