package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Brachiosaurus extends Dinosaur implements IWalk{

    public Brachiosaurus(FeedType feedType, String type, String name){
        super(feedType, type, name);
    }
}
